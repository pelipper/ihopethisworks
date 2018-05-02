
package collatzproject;


import java.util.List;

/**
 * This is the interface which the CollatzProxy and RealCollatz classes implement
 * @author Stuart Pelletier
 */
public interface Collatz {
    CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound);
    List<CollatzCalculation> getCalculations(int lowerBound, int upperBound);
}
