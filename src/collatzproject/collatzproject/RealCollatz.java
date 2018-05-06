/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.ArrayList;
import java.util.List;

/**
 * RealCollatz class, implements Collatz
 * 
 * @author Stuart Pelletier
 */
public class RealCollatz implements Collatz{
    private int lowerBound;
    private int upperBound;

    List<CollatzCalculation> collatzNums = new ArrayList<>();
/**
 * Constructor for RealCollatz object
 * @param lowerBound int, lower bound
 * @param upperBound int, upper bound
 */
    RealCollatz(int lowerBound, int upperBound) throws IllegalArgumentException{

        if(lowerBound < 1){
            throw new IllegalArgumentException("Lower Bound must be greater than 0");
        }
        if(upperBound < lowerBound){
            throw new IllegalArgumentException("Upper Bound must be greater than Lower Bound");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        collatzListInitialization();
    }
/**
 * private helper method for initializing the data fields
 */
    void collatzListInitialization(){
        for(int i = lowerBound; i <= upperBound; i++){
           CollatzCalculation calc = new CollatzCalculation(i);
           collatzNums.add(calc);
        }
    }

/**
 * 
 * @return int, lower bound
 */
    int getLowerBound() {
        return lowerBound;
    }
/**
 * 
 * @param lowerBound, int to set lowerBound to
 */
    void setLowerBound(int lowerBound) throws IllegalArgumentException{
        if(lowerBound < this.lowerBound){
            throw new IllegalArgumentException("lowerBound must not be less than current lowerBound");
        }
        this.lowerBound = lowerBound;
    }
/**
 * 
 * @return int upperBound
 */
    int getUpperBound() {
        return upperBound;
    }
/**
 * 
 * @param upperBound, int to set upperBound to
 */
    void setUpperBound(int upperBound) {
        if(upperBound > this.upperBound){
            throw new IllegalArgumentException("upperBound must not be greater than current upperBound");
        }
        this.upperBound = upperBound;
    }


/**
 * Gets number of iterations for each integer between lowerBound and upperBound
 * @param lowerBound int, lower bound
 * @param upperBound int, upper bound
 * @return CollatzNumber object with values between the bounds
 */
    @Override
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound)throws IllegalArgumentException {
        if(upperBound > this.upperBound){
            throw new IllegalArgumentException("upperBound must not be greater than current upperBound");
        }
        if(lowerBound < this.lowerBound){
            throw new IllegalArgumentException("lowerBound must not be less than current lowerBound");
        }
        List<Integer> initialInts = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < collatzNums.size(); i++){
            initialInts.add(collatzNums.get(i).getInitialInt());
            numbers.add(collatzNums.get(i).getNumIterations());
        }
        return new CollatzNumbers(initialInts, numbers);
    }
    /**
     * Get full calculations for each integer between lowerBound and upperBound
     * @param lowerBound int, lower bound
     * @param upperBound int, upper bound
     * @return List of CollatzCalculation objects with values between the bounds
     */
    @Override
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound)throws IllegalArgumentException {
        if(upperBound > this.upperBound){
            throw new IllegalArgumentException("upperBound must not be greater than current upperBound");
        }
        if(lowerBound < this.lowerBound){
            throw new IllegalArgumentException("lowerBound must not be less than current lowerBound");
        }
        return collatzNums;
    }
}
