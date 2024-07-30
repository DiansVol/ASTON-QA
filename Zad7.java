public class Zad7 {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    public static void main(String[] args) {
        int number1 = -5;
        int number2 = 3;
        System.out.println(number1 + " is negative: " + isNegative(number1));
        System.out.println(number2 + " is negative: " + isNegative(number2));
    }
}
