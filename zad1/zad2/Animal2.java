public abstract class Animal2 {
    public String name;
    public static int animalCount = 0;

    public Animal2(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}