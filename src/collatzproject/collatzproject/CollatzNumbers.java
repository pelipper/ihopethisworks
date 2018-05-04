package collatzproject;

import java.util.List;

/**
 * CollatzNumbers class
 * This class keeps track of 2 lists, the initial integers, and the number of iterations (collatzNums)
 * This prevents indexing issues after predicates or bounds have been set
 * @author Stuart Pelletier
 */
public class CollatzNumbers {
    List<Integer> initialInts;
    List<Integer> collatzNums;
    /**
     * Constructor for CollatzNumbers class
     * @param initialInts is a list of initial integers
     * @param collatzNums is a list of number of iterations to get to 1 of the same-indexed initialInt
     */
    public CollatzNumbers(List<Integer> initialInts, List<Integer> collatzNums){
        this.initialInts = initialInts;
        this.collatzNums = collatzNums;
    }
    /**
     * 
     * @return collatzNums
     */
    public List<Integer> getCollatzNums(){
        return collatzNums;
    }
    /**
     * 
     * @return initialInt
     */
    public List<Integer> getInitialInts(){
        return initialInts;
    }
}
