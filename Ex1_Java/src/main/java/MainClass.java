import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {

        AnimalManger animalManger = new AnimalManger();
        List<Animal> animalList = null;

        Class managerClass = animalManger.getClass();

        try {
            Method createCatsMethod = managerClass.getMethod("createCatList");
            createCatsMethod.setAccessible(true);
            animalList = (List<Animal>) createCatsMethod.invoke(animalManger);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Stream<Animal> stream = animalList.stream();

        // Q1.
        Predicate p1 = animalManger.Q1Filter();

        // Q2.
        Predicate p2 = animalManger.Q2Filter();

        List<CatBreedEnum> catBreedEnums = (List<CatBreedEnum>) stream
                .filter(p1)
                .filter(p2)
                .map(animal -> ((Cat)animal).getBreed())
                .collect(Collectors.toList());


        animalManger.printBreedTypes(catBreedEnums);

    }
}
