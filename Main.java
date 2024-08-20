public class Main {
    public static void main(String[] args) {
        Dog bobik = new Dog("Лорд");
        Cat murka = new Cat("Снежок");

        bobik.run(150);
        bobik.swim(50);
        murka.run(100);
        murka.swim(200);
    }
}