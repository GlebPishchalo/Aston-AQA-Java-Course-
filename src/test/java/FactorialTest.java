import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testCalculateFactorialZero() {
        long result = Factorial.calculateFactorial(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialOne() {
        long result = Factorial.calculateFactorial(1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testCalculateFactorialPositiveNumber() {
        long result = Factorial.calculateFactorial(5);
        Assert.assertEquals(result, 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialNegativeNumber() {
        Factorial.calculateFactorial(-5);
    }
}