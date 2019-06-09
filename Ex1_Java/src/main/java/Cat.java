public class Cat extends Animal {
    private CatBreedEnum breed;

    public Cat(String name) {
        super(name);
    }

    public CatBreedEnum getBreed() {
        return breed;
    }

    public void setBreed(CatBreedEnum breed) {
        this.breed = breed;
    }
}
