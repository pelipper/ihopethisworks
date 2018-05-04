package collatzproject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CollatzProxyTest {

    @Test
    void getCollatzNumbers() {
        int lower = 1;
        int upper = 10;
        CollatzProxy collatzProxy = new CollatzProxy(lower, upper);
        System.out.println(collatzProxy.getCollatzNumbers(lower, upper).toString());
    }

    @Test
    void getCalculations() {
    }

    @Test
    void getCollatzNumbers1() {
    }

    @Test
    void getCollatzNumbers2() {
    }

    @Test
    void getCalculations1() {
    }

    @Test
    void getCalculations2() {
    }

    @Test
    void getLowerBound() {
    }

    @Test
    void setLowerBound() {
    }

    @Test
    void getUpperBound() {
    }

    @Test
    void setUpperBound() {
    }

    @Test
    void getPredicateType() {
    }

    @Test
    void setPredicateType() {
    }

    @Test
    void getPredicateNumber() {
    }

    @Test
    void setPredicateNumber() {
    }
}