
package src.collatzproject;


import java.util.List;

/**
 * This is the interface which the CollatzProxy and RealCollatz classes implement
 * @author Stuart Pelletier
 */
public interface Collatz {
    collatzproject.CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound);
    List<collatzproject.CollatzCalculation> getCalculations(int lowerBound, int upperBound);
}
