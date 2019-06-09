import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        int i = 1;
        for (CatBreedEnum catBreedEnum : CatBreedEnum.values()) {

            Cat cat = new Cat("cat"+i);
            cat.setBreed(catBreedEnum);
            i++;
            animalList.add(cat);
        }

        Stream<Animal> stream = animalList.stream();

        // Q1.
        Predicate p1 = Q1Filter();

        // Q2.
        Predicate p2 = Q2Filter();

        List<CatBreedEnum> catBreedEnums = (List<CatBreedEnum>) stream
                .filter(p1)
                .filter(p2)
                .map(animal -> ((Cat)animal).getBreed())
                .collect(Collectors.toList());

        System.out.println(catBreedEnums);

    }

    //--------------------------------------------------------------

    static Predicate Q1Filter(){
        Predicate p1 = animal -> ((Cat)animal).getBreed().toString().startsWith("A");
        Predicate p2 = animal -> ((Cat)animal).getBreed().toString().startsWith("C");
        Predicate p3 = animal -> ((Cat)animal).getBreed().toString().startsWith("P");
        Predicate p4 = p1.or(p2).or(p3);
        return p4;
    }

    //--------------------------------------------------------------

    static Predicate Q2Filter(){
        Predicate<Animal> p2 = animal -> {
            int a = Integer.parseInt(animal.getName().substring(3));
            return a%2 ==0;
        };
        return p2;
    }

    //--------------------------------------------------------------
}
