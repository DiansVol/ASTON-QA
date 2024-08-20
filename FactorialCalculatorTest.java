import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.;

public class FactorialCalculatorTest {

    @Test
    void calculateFactorial_zero() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(1, calculator.calculateFactorial(0));
    }

    @Test
    void calculateFactorial_positive() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(120, calculator.calculateFactorial(5));
    }

    @Test
    void calculateFactorial_negative() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }
}