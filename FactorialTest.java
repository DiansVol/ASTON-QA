import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.calculateFactorial(-1);
    }
}