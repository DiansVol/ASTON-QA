public class Main2 {
    public static void main(String[] args) {
        Dog2 bobik = new Dog2("Бобик");
        Cat2 murka = new Cat2("Мурка");
        Dog2 rex = new Dog2("Рекс");
        Cat2 barsik = new Cat2("Барсик");

        bobik.run(150);
        murka.swim(50);
        rex.run(500);
        barsik.run(250);

        System.out.println("Создано собак: " + Dog2.getDogCount());
        System.out.println("Создано котов: " + Cat2.getCatCount());
        System.out.println("Создано животных: " + Animal2.getAnimalCount());
    }
}