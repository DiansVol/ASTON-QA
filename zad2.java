import java.util.Arrays;

public class zad2 {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4 на 4.");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные в ячейке [" + i + "][" + j + "].", i, j);
                }
            }
        }
        return sum;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        private final int row;
        private final int col;

        public MyArrayDataException(String message, int row, int col) {
            super(message);
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "a", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(validArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage() + " (строка: " + e.getRow() + ", столбец: " + e.getCol() + ")");
        }

        try {
            int sum = processArray(invalidArray);
            System.out.println("Сумма элементов: " + sum); 
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage() + " (строка: " + e.getRow() + ", столбец: " + e.getCol() + ")");
        }
    }
}
