package collatzproject;
import java.util.ArrayList;
import java.util.Arrays;


import org.junit.Test;
import static org.junit.Assert.*;

public class CollatzNumbersTest {

    @Test
    public void getCollatzNums() {
        ArrayList<Integer> initialInts = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 7, 2, 5, 8, 16, 3, 19, 6));

        CollatzNumbers collatzNumbers = new CollatzNumbers(initialInts, testCollatz);
        assertTrue(collatzNumbers.collatzNums.equals(collatzNumbers.getCollatzNums()));
    }

    @Test
    public void getInitialInts() {
        ArrayList<Integer> initialInts = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 7, 2, 5, 8, 16, 3, 19, 6));

        CollatzNumbers collatzNumbers = new CollatzNumbers(initialInts, testCollatz);
        assertTrue(collatzNumbers.initialInts.equals(collatzNumbers.getInitialInts()));
    }
}