public class Zad3 {

    public void printColor() {
        int value = 50;
        if (value < 0) {
            System.out.println("Красный");
        } else if (value >= 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    public static void main(String[] args) {
        Zad3 Zad3 = new Zad3();
        Zad3.printColor();
    }
}
