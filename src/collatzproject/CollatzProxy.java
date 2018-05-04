
package collatzproject;

import java.util.ArrayList;
import java.util.List;
/**
 * CollatzProxy class, implements Collatz
 * The proxy allows for the use of predicates to filter the data from RealCollatz
 * @author Stuart Pelletier
 */
public class CollatzProxy implements src.collatzproject.Collatz {
    public collatzproject.RealCollatz realCollatz;
    private int lowerBound;
    private int upperBound;
    public String predicateType;
    public int predicateNumber;
    List<Integer> collatzNums = new ArrayList<>();
    private final String [] predicateTypes = {"Multiple", "Prime", "Power"};
        
        
    
/**
 * Constructor for CollatzProxy
 * @param lowerBound is the lower bound of integers to calculate, must be > 0
 * @param upperBound is the upper bound of integers to calculate, must be >= lowerBound
 */
    public CollatzProxy(int lowerBound, int upperBound) throws IllegalArgumentException{
        if(lowerBound < 1){
            throw new IllegalArgumentException("Lower Bound must be greater than 0");
        }
        if(upperBound < lowerBound){
            throw new IllegalArgumentException("Upper Bound must be greater than Lower Bound");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        realCollatz = new collatzproject.RealCollatz(lowerBound, upperBound);
        
    }

    /**
     * Helper method that checks if toCheck is a power of the power parameter
     * @param toCheck
     * @param power
     * @return 
     */
    private boolean isPowerOf(int toCheck, int power){
        int temp = toCheck;
        while(temp > (power - 1) && temp%power == 0){
            temp = temp/power;
        }
        if(temp==1){
            return true;
        }
        return false;
    }
    /**
     * helper method that checks if n is prime
     * @param n
     * @return 
     */
    private boolean isPrime(int n){
        if(n==2){
            return true;
        }
        if(n%2 == 0){
            return false;
        }
        for(int i = 3; (i^2)<n; i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    /**
     * get function for CollatzNumbers
     * @param lowerBound lower bound of collatz numbers, must be greater than lowerBound field
     * @param upperBound upper bound of collatz numbers, must be less than upperBound field
     * @return 
     */
    @Override
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound)throws IllegalArgumentException{
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        return realCollatz.getCollatzNumbers(lowerBound, upperBound);
    }
    /**
     * get function for CollatzCalculations
     * @param lowerBound lower bound of calculations, must be greater than lowerBound field
     * @param upperBound upper bound of calculations, must be less than upperBound field
     * @return 
     */
    @Override
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound){
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        return realCollatz.getCalculations(lowerBound, upperBound);
    }

/**
 * This is the getCollatzNumbers function for non-prime predicates
 * @param lowerBound
 * @param upperBound
 * @param predicateType
 * @param predicateNumber
 * @return
 * @throws IllegalArgumentException 
 */
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber)throws IllegalArgumentException {
        boolean illegalPred = true;
        for(int i = 0; i < predicateTypes.length; i++){
            if(predicateType.equals(predicateTypes[i])){
                illegalPred = false;
            }
        }
        
        if(illegalPred){
            throw new IllegalArgumentException("Predicate type must be Multiple, Power, or Prime");
        }
        if(predicateType.equals("Prime")){
            throw new IllegalArgumentException("Please do not pass a predicate number for a prime predicate");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        CollatzNumbers unfilteredList = realCollatz.getCollatzNumbers(lowerBound, upperBound);
        List<Integer> filteredList = new ArrayList<>();
        List<Integer> initialIntList = new ArrayList<>();
        if(predicateType.equals("Multiple")){
            for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
                if(unfilteredList.getInitialInts().get(i)%predicateNumber == 0){
                    filteredList.add(unfilteredList.getCollatzNums().get(i));
                    initialIntList.add(i);
                }
            }
        }
        if(predicateType.equals("Power")){
            for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
                if(isPowerOf(unfilteredList.getInitialInts().get(i), predicateNumber)){
                    filteredList.add(unfilteredList.getCollatzNums().get(i));
                    initialIntList.add(i);
                }
            }
        }
        return new CollatzNumbers(initialIntList, filteredList);
    }
    
    /**
     * This is the getCollatzNumbers function for prime predicate
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @return
     * @throws IllegalArgumentException 
     */
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound, String predicateType)throws IllegalArgumentException {
        if(!predicateType.equals("Prime")){
            throw new IllegalArgumentException("Predicate specify a predicate number for non-prime predicates");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        CollatzNumbers unfilteredList = realCollatz.getCollatzNumbers(lowerBound, upperBound);
        List<Integer> filteredList = new ArrayList<>();
        List<Integer> initialIntList = new ArrayList<>();
        for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
            if(isPrime(unfilteredList.getInitialInts().get(i))){
                filteredList.add(unfilteredList.getCollatzNums().get(i));
                initialIntList.add(i);
            }
        }
        
        return new CollatzNumbers(initialIntList, filteredList);
    }
    /**
     * This is the getCalculations function for non-prime predicates
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @param predicateNumber
     * @return
     * @throws IllegalArgumentException 
     */
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber)throws IllegalArgumentException {
        boolean illegalPred = true;
        for(int i = 0; i < predicateTypes.length; i++){
            if(predicateType.equals(predicateTypes[i])){
                illegalPred = false;
            }
        }
        if(illegalPred){
            throw new IllegalArgumentException("Predicate type must be Multiple, Power, or Prime");
        }
        if(predicateType.equals("Prime")){
            throw new IllegalArgumentException("Please do not pass a predicate number for a prime predicate");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        
        
        List<CollatzCalculation> unfilteredList = realCollatz.getCalculations(lowerBound, upperBound);
        List<CollatzCalculation> filteredList = new ArrayList<>();
        if(predicateType.equals("Multiple")){
            for(int i = 0; i<unfilteredList.size(); i++){
                if(unfilteredList.get(i).getInitialInt()%predicateNumber == 0){
                    filteredList.add(unfilteredList.get(i));
                }
            }
        }
        if(predicateType.equals("Power")){
            for(int i = 0; i<unfilteredList.size(); i++){
                if(isPowerOf(unfilteredList.get(i).getInitialInt(), predicateNumber)){
                    filteredList.add(unfilteredList.get(i));
                }
            }
        }
        return filteredList;
    }
    /**
     * This is the gerCalcuations function for prime predicate
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @return
     * @throws IllegalArgumentException 
     */
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType)throws IllegalArgumentException {
        if(!predicateType.equals("Prime")){
            throw new IllegalArgumentException("Predicate specify a predicate number for non-prime predicates");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }

        List<CollatzCalculation> unfilteredList = realCollatz.getCalculations(lowerBound, upperBound);
        List<CollatzCalculation> filteredList = new ArrayList<>();
        for(int i = 0; i<unfilteredList.size(); i++){
            if(isPrime(unfilteredList.get(i).getInitialInt())){
                filteredList.add(unfilteredList.get(i));
            }
        }
        return filteredList;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public String getPredicateType() {
        return predicateType;
    }

    public void setPredicateType(String predicateType) {
        this.predicateType = predicateType;
    }

    public int getPredicateNumber() {
        return predicateNumber;
    }

    public void setPredicateNumber(int predicateNumber) {
        this.predicateNumber = predicateNumber;
    }


}
