package collatzproject;



import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class CollatzCalculationTest {

    @Test
    public void getInitialInt() {
        CollatzCalculation collatzCalculation = new CollatzCalculation(1);
        assertEquals(collatzCalculation.getInitialInt(), 1);
    }

    @Test
    public void calculationSteps() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 16, 8, 4, 2));
        CollatzCalculation collatzCalculation = new CollatzCalculation(10);
        assertEquals(collatzCalculation.calculationSteps(), numbers);
    }

    @Test
    public void getNumIterations() {
        CollatzCalculation collatzCalculation = new CollatzCalculation(10);
        assertEquals(6, collatzCalculation.getNumIterations());
    }
}