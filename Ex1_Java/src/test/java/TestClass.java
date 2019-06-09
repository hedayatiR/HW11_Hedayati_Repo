import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {

    private static List<Animal> catList;
    private static AnimalManger animalManger;


    @BeforeAll
    static void createCatList() {
        animalManger = new AnimalManger();
        Class managerClass = animalManger.getClass();

        try {
            Method createCatsMethod = managerClass.getDeclaredMethod("createCatList");
            createCatsMethod.setAccessible(true);
            catList = (List<Animal>) createCatsMethod.invoke(animalManger);
            createCatsMethod.setAccessible(false);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    // Test 1
    @Test
    @DisplayName("Test of cat list creation")
    void testCreateCatList() {

        assertTrue(testCreateCatListHelperMethod(catList), "Cat creation Failed!");

    }

    boolean testCreateCatListHelperMethod(List<Animal> catListlList) {
        if (catListlList.size() != 99)
            return false;
        for (Animal animal : catListlList) {
            if (!animal.getName().toString().startsWith("cat"))
                return false;

            try {
                int a = Integer.parseInt(animal.getName().substring(3));

            } catch (NumberFormatException e) {
                System.out.println("Cat name is wrong. It doesn't have number.");
                return false;
            }
        }
        return true;
    }

    // Test 2
    @Test
    @DisplayName("test filtering of cats with breed")
    void testFilteringCatsWithBreed() {
        assertTrue(testFilteringCatsWithBreedHelperMethod(),
                "filtering of cats with breed Failed!"
        );
    }

    boolean testFilteringCatsWithBreedHelperMethod() {
        boolean match = catList.stream().filter(animalManger.Q1Filter()).allMatch(
                animal -> {
                    String breed = ((Cat) animal).getBreed().toString();
                    if (!(breed.startsWith("A") || breed.startsWith("C") || breed.startsWith("P")))
                        return false;
                    return true;
                });
        return match;
    }

    // Test 3
    @Test
    @DisplayName("test filtering of cats with name")
    void testFilteringCatsWithName() {
        assertTrue(testFilteringCatsWithNameHelperMethod(),
                "filtering of cats with name Failed!"
        );
    }

    boolean testFilteringCatsWithNameHelperMethod() {
        boolean match = catList.stream().filter(animalManger.Q2Filter()).allMatch(
                animal -> {
                    int nameNumber = Integer.parseInt(((Animal) animal).getName().substring(3));
                    if (nameNumber % 2 != 0)
                        return false;
                    return true;
                });
        return match;
    }

    // Test 4
    @Test
    @DisplayName("test printing of cats' breed")
    void testPrintingBreedTypes(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Predicate p1 = animalManger.Q1Filter();
        Predicate p2 = animalManger.Q2Filter();
        List<CatBreedEnum> catBreedEnums = (List<CatBreedEnum>) catList.stream()
                .filter(p1)
                .filter(p2)
                .map(animal -> ((Cat)animal).getBreed())
                .collect(Collectors.toList());

        animalManger.printBreedTypes(catBreedEnums);

        String expectedOutput  = "Aegean\r\n" +
                "American_Curl\r\n" +
                "American_Wirehair\r\n" +
                "Arabian_Mau\r\n" +
                "Asian_Semilonghair\r\n" +
                "Chantilly_Tiffany\r\n" +
                "Chausie\r\n" +
                "Colorpoint_Shorthair\r\n" +
                "Cymric\r\n" +
                "Persian_Modern\r\n" +
                "Peterbald\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

}
