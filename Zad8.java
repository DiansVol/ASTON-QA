public class Zad8 {
    public static void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        String text = "Привет!";
        int count = 5;
        printStringMultipleTimes(text, count);
    }
}
