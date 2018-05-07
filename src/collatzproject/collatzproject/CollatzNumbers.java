package collatzproject;

import java.util.List;

/**
 * CollatzNumbers class
 * This class keeps track of 2 lists, the initial integers, and the number of iterations (collatzNums)
 * This prevents indexing issues after predicates or bounds have been set
 * @author Stuart Pelletier
 */
class CollatzNumbers {
    List<Integer> initialInts;
    List<Integer> collatzNums;
    /**
     * Constructor for CollatzNumbers class
     * @param initialInts is a list of initial integers
     * @param collatzNums is a list of number of iterations to get to 1 of the same-indexed initialInt
     */
    CollatzNumbers(List<Integer> initialInts, List<Integer> collatzNums){
        this.initialInts = initialInts;
        this.collatzNums = collatzNums;
    }
    /**
     * 
     * @return collatzNums a list of numbers that are the total iterations needed to get to 1 from each number in {@link #initialInts}
     */
    List<Integer> getCollatzNums(){
        return collatzNums;
    }
    /**
     * 
     * @return initialInts the list of initial integers on which to perform the calculations
     */
    List<Integer> getInitialInts(){
        return initialInts;
    }
}
