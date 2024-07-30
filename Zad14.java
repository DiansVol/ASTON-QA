public class Zad14 {

    public static void main(String[] args) {
        int len = 5;
        int initialValue = 10;
        int[] array = createArray(len, initialValue);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
