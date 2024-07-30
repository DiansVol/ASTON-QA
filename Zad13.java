import java.util.Arrays;

public class Zad13 {
    public static void main(String[] args) {
        int n = 5;
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}