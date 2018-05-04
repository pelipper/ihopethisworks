package collatzproject;

import java.util.ArrayList;
import java.util.List;
/**
 * This class keeps track of a full chain of Collatz calculations,
 * initialInt is the starting integer
 * calculationSteps is a list containing the full steps of the calculation
 * numIterations is the number of iterations needed to get to 1
 * @author Stuart Pelletier
 */
public class CollatzCalculation {
    private int initialInt;
    private List<Integer> calculationSteps;
    private int numIterations;
    /**
     * constructor for CollatzCalculation
     * @param initialInt is the starting integer
     * @throws IllegalArgumentException when initialInt is not a natural number
     */
    CollatzCalculation(int initialInt) throws IllegalArgumentException{
        if(initialInt <= 0){
            throw new IllegalArgumentException("Input integer must be greater than 0");
        }
        calculationSteps = new ArrayList<>();
        this.initialInt = initialInt;
        initializer();
    }
    /**
     * Helper method that initializes all of the values
     */
   private void initializer(){
        int temp = initialInt;
            while(temp != 1){
                calculationSteps.add(temp);
                numIterations++;
                if(temp%2 == 0){
                    temp = temp/2;
                } else {
                    temp = (3*temp) + 1;
                }

            }
    }

    /**
     *
     * @return initialInt
     */
    int getInitialInt(){
        return initialInt;
    }
    /**
     *
     * @return calculationSteps
     */
    public List<Integer> calculationSteps(){
        return calculationSteps;
    }
    /**
     *
     * @return numIterations
     */
    int getNumIterations(){
        return numIterations;
    }

}
