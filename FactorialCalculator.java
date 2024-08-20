public class FactorialCalculator {

    public long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным.");
        } else if (number == 0) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial = i;
            }
            return factorial;
        }
    }
}