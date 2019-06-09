import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        List<Animal> myAnimals = new ArrayList<>();
        int i = 1;
        for (CatBreedEnum catBreedEnum : CatBreedEnum.values()) {

            Cat cat = new Cat("cat"+i);
            cat.setBreed(catBreedEnum);
            i++;
            myAnimals.add(cat);
        }


        Stream<Animal> stream = myAnimals.stream();

        // Q1.
        Predicate p1 = animal -> ((Cat)animal).getBreed().toString().startsWith("A");
        Predicate p2 = animal -> ((Cat)animal).getBreed().toString().startsWith("C");
        Predicate p3 = animal -> ((Cat)animal).getBreed().toString().startsWith("P");
        Predicate p4 = p1.or(p2).or(p3);


        stream.filter(p4)
                .forEach(e -> System.out.println(((Cat)e).getBreed()) );

    }
}
