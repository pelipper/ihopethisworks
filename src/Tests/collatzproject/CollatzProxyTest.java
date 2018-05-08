package collatzproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class CollatzProxyTest {


    @Test
    public void getCalculations() {
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);
        System.out.println(collatzProxy.getCalculations(1, 10));
    }

    @Test
    public void getCollatzNumbersNonPrimeMult() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(1, 2, 8, 3, 6));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Multiple", 2).getCollatzNums(), testCollatz);
    }

    @Test
    public void getCollatzNumbersNonPrimePower() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Power", 2).getCollatzNums(), testCollatz);


    }

    @Test
    public void getCollatzNumbersPrime() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 5, 16));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Prime").getCollatzNums(), testCollatz);
    }

    @Test
    public void setPredicateTypeTestPredType() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(1, 10);
        collatzProxyTest.setPredicateType("illegalarg");
        String result = collatzProxyTest.getPredicateType();
        if (!(result.equals("Primes") | result.equals("Power") | result.equals("Multiple"))) {
            throw new IllegalArgumentException("Predicate type must be Multiple, Power, or Prime");


        }

    }

    @Test
    public void setPredicateNumberTestBounds() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(0, 1);
        if (collatzProxyTest.getLowerBound() < 1) {
            throw new IllegalArgumentException("Lower Bound must be greater than 0");
        }
    }

    @Test
    public void setUpperBoundTestBounds() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(0, 0);
        if (collatzProxyTest.getUpperBound() == 0) {
            throw new IllegalArgumentException("Upper Bound must be greater than 0");
        }
    }


    @Test
    public void setLowerBoundTestEquality() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(0, 0);
        if (collatzProxyTest.getUpperBound() == 0) {
            throw new IllegalArgumentException("Upper Bound must be greater than 0");
        }
    }

    @Test
    public void getCalculationsTestLowerBounds() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(2, 4);
        String result = collatzProxyTest.getCalculations(2, 3).get(0).toString();
        if (!(result.equals("2"))) ;
        throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");

    }

    @Test
    public void getCalculationsTestUpperBounds() throws IllegalArgumentException {
        CollatzProxy collatzProxyTest = new CollatzProxy(2, 4);
        String result = collatzProxyTest.getCalculations(2, 3).get(0).toString();
        if (!(result.equals("4"))) ;
        throw new IllegalArgumentException("upper bound must not be less than initial upper bound");

    }

    @Test
    public void getCollatzNumbersTestLowerBounds() {
        CollatzProxy collatzProxyTest = new CollatzProxy(0, 3);
        String result = collatzProxyTest.getCollatzNumbers(2, 3).toString();
        if (!(result.equals("3"))) ;
        throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");

    }

    @Test
    public void getCollatzNumbersTestUpperBounds() {
        CollatzProxy collatzProxyTest = new CollatzProxy(0, 3);
        String result = collatzProxyTest.getCalculations(2, 3).get(0).toString();
        if (!(result.equals("1"))) ;
        throw new IllegalArgumentException("upper bound must not be less than initial upper bound");

    }

}


