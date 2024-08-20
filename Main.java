public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        Cat murka = new Cat("Мурка");
        Dog rex = new Dog("Рекс");
        Cat barsik = new Cat("Барсик");

        bobik.run(150);
        murka.swim(50);
        rex.run(500);
        barsik.run(250);

        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());
        System.out.println("Создано животных: " + Animal.getAnimalCount());
    }
}