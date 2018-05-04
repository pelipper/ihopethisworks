package collatzproject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollatzProxyTest {


    @Test
    void getCalculations() {
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);
        System.out.println(collatzProxy.getCalculations(1, 10));
    }

    @Test
    void getCollatzNumbersNonPrimeMult() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(1, 2, 8, 3, 6));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Multiple", 2).getCollatzNums(), testCollatz);
    }

    @Test
    void getCollatzNumbersNonPrimePower() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Power", 2).getCollatzNums(), testCollatz);


    }

    @Test
    void getCollatzNumbersPrime() {
        ArrayList<Integer> testCollatz = new ArrayList<>(Arrays.asList(0, 1, 5, 16));
        CollatzProxy collatzProxy = new CollatzProxy(1, 10);

        assertEquals(collatzProxy.getCollatzNumbers(1, 10, "Prime").getCollatzNums(), testCollatz);
    }

}
