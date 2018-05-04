package collatzproject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RealCollatzTest {

    @Test
    void getLowerBound() {
        RealCollatz rc = new RealCollatz(0, 1);
        assertEquals(0, rc.getLowerBound());
    }

    @Test
    void setLowerBound() {
        RealCollatz rc = new RealCollatz(0, 1);
        rc.setLowerBound(1);
        assertEquals(rc.getLowerBound(), 1);
    }

    @Test
    void getUpperBound() {
        RealCollatz rc = new RealCollatz(0, 1);
        assertEquals(1, rc.getUpperBound());
    }

    @Test
    void setUpperBound() {
        RealCollatz rc = new RealCollatz(0, 1);
        rc.setUpperBound(2);
        assertEquals(rc.getLowerBound(), 2);
    }

    @Test
    void getCollatzNumbers() {
        int lower = 1;
        int upper = 10;
        List<Integer> initialInts = new ArrayList<>(upper);
        List<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 7, 2, 5, 8, 16, 3, 19, 6));
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        for (int i = lower; i <= upper; i++) {
            initialInts.add(i);
            numbers.add(realCollatz.collatzNums.get(i - 1).getNumIterations());
        }
        assertEquals(initialInts, realCollatz.getCollatzNumbers(lower, upper).getInitialInts());
        assertEquals(numbers, testCollatz);

    }

    @Test
    void getCalculations() {
        int lower = 1;
        int upper = 10;
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        realCollatz.collatzListInitialization();
        assertTrue(realCollatz.collatzNums.equals(realCollatz.getCalculations(lower, upper)));

    }

    @Test
    void collatzListInitialization() { int lower = 1;
        int upper = 10;
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        realCollatz.collatzListInitialization();

    }
}