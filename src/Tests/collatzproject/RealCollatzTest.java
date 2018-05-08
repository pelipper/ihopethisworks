package collatzproject;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RealCollatzTest {

    @Test
    public void getLowerBound() {
        RealCollatz rc = new RealCollatz(1, 2);
        assertEquals(1, rc.getLowerBound());

    }

    @Test
    public void setLowerBound() throws IllegalArgumentException{
        RealCollatz rc = new RealCollatz(1, 2);
        rc.setLowerBound(1);
        assertEquals(rc.getLowerBound(), 1);
        if (rc.getLowerBound() < 1){
            throw new IllegalArgumentException("lowerBound Number must be greater than 0");
        }
    }

    @Test
    public void getUpperBound() {
        RealCollatz rc = new RealCollatz(1, 2);
        assertEquals(2, rc.getUpperBound());
    }

    @Test
    public void setUpperBound()throws IllegalArgumentException {
        RealCollatz rc = new RealCollatz(1, 2);
        rc.setUpperBound(2);
        assertEquals(rc.getUpperBound(), 2);
        if (rc.getLowerBound() < 1){
            throw new IllegalArgumentException("upperBound Number must be greater than 0");
        }

    }

    @Test
    public void getCollatzNumbers() throws IllegalArgumentException{
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
        if (!(initialInts.get(0).equals(realCollatz.getLowerBound()))){
            throw new IllegalArgumentException("lowerBound must not be less than current lowerBound");
        }else  if (!(initialInts.get(initialInts.size()-1).equals(realCollatz.getUpperBound()))){
            throw new IllegalArgumentException("upperBound must not be less than current upperBound");
        }
    }

    @Test
    public void getCalculations() {
        int lower = 1;
        int upper = 10;
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        realCollatz.collatzListInitialization();
        assertTrue(realCollatz.collatzNums.equals(realCollatz.getCalculations(lower, upper)));

    }

    @Test
    public void getCalculationsTestLowerBound() throws IllegalArgumentException{
        RealCollatz realCollatz = new RealCollatz(1,10);
        if (!(realCollatz.getCalculations(1,2).get(0).equals(1))){
            throw new IllegalArgumentException("lowerBound must not be less than current lowerBound");
        }
    }


    @Test
    public void getCalculationsTestUpperBound() throws IllegalArgumentException{
        RealCollatz realCollatz = new RealCollatz(1,2);
        if (!(realCollatz.getCalculations(1,2).get(2).equals(2))){
            throw new IllegalArgumentException("upperBound must not be less than current upperBound");
        }
    }
    @Test
    public void collatzListInitialization() { int lower = 1;
        int upper = 10;
        RealCollatz realCollatz = new RealCollatz(lower, upper);
        realCollatz.collatzListInitialization();

    }
}