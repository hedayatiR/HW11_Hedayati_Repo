import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestClass {

    private static List<Animal> catList;
    private static AnimalManger animalManger;


    @BeforeAll
    static void createCatList() {
        animalManger = new AnimalManger();
        catList = animalManger.createCatList();
    }


    // Test 1
    @Test
    @DisplayName("Test of cat list creation")
    void testCreateCatList() {

        Assertions.assertTrue(testCreateCatListHelperMethod(catList), "Cat creation Failed!");

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
        Assertions.assertTrue(testFilteringCatsWithBreedHelperMethod(),
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
        Assertions.assertTrue(testFilteringCatsWithNameHelperMethod(),
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

}
