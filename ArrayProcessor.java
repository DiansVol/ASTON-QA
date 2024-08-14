public class ArrayProcessor {

    public static void processArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4 на 4");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] validArray = {{"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"},
                {"m", "n", "o", "p"}};

        String[][] invalidArray = {{"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}};

        try {
            processArray(validArray);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processArray(invalidArray);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}