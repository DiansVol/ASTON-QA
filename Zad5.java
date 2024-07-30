public class Zad5 {
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void main(String[] args) {
        // Примеры использования метода
        System.out.println(checkSum(5, 5));
        System.out.println(checkSum(1, 9));
        System.out.println(checkSum(3, 7));
        System.out.println(checkSum(1, 1));
        System.out.println(checkSum(25, -5));
    }
}