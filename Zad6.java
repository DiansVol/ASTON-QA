public class Zad6 {
    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-10);
        checkNumber(0);
    }
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " - положительное.");
        } else {
            System.out.println("Число " + number + " - отрицательное.");
        }
    }
}
