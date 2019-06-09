import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AnimalManger {

    public List<Animal> createCatList(){
        List<Animal> animalList = new ArrayList<>();
        int i = 1;
        for (CatBreedEnum catBreedEnum : CatBreedEnum.values()) {

            Cat cat = new Cat("cat"+i);
            cat.setBreed(catBreedEnum);
            i++;
            animalList.add(cat);
        }

        // uncomment lines below for wrong creation of cats

//        animalList.remove(98);
//        Cat cat = new Cat("cat");
//        cat.setBreed(CatBreedEnum.Aegean);
//        animalList.add(cat);
//

        return animalList;
    }

    //--------------------------------------------------------------

    public Predicate Q1Filter(){
        Predicate p1 = animal -> ((Cat)animal).getBreed().toString().startsWith("A");
        Predicate p2 = animal -> ((Cat)animal).getBreed().toString().startsWith("C");
        Predicate p3 = animal -> ((Cat)animal).getBreed().toString().startsWith("P");

        Predicate p4 = p1.or(p2).or(p3);
        return p4;
    }

    //--------------------------------------------------------------

    public Predicate Q2Filter(){
        Predicate<Animal> p2 = animal -> {
            int a = Integer.parseInt(animal.getName().substring(3));
            return a%2 == 0;
        };
        return p2;
    }

    //--------------------------------------------------------------

    public void printBreedTypes(List<CatBreedEnum> catBreedEnumList){
        for (CatBreedEnum catBreedEnum:
             catBreedEnumList) {
            System.out.println(catBreedEnum);
        }
    }

}
