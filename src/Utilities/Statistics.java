package Utilities;

/**
 * A set of counters to keep track of accesses,hits, and misses.
 * @author krclemmons
 */
public class Statistics {
    private int numberOfHits; //< The number of hits. 
    private int numberOfMisses; //< The number of misses.
    private int numberOfAccesses; //< The number of accesses. 
    private double hitRate; //< The rate at which hits occur.
    private double missRate; //< The rate at which misses occur. 
    private double ratioHitsToMisses; //< Ratio of hits to misses. 
    private double ratioMissesToHits; //< Ratio of misses to hits. 
    
    /**
     * Default constructor. Initializes all values to zero. 
     */
    public Statistics(){
        numberOfHits = 0; 
        numberOfMisses = 0; 
        numberOfAccesses = 0; 
        hitRate = 0.0; 
        missRate = 0.0; 
        ratioHitsToMisses = 0.0; 
        ratioMissesToHits = 0.0; 
    }
    
    /**
     * Increments the number of hits and total accesses by 1. 
     */
    public void addHit(){
        numberOfHits++; 
        numberOfAccesses++; 
    }
    
    /**
     * Increments the number of misses and total accesses by 1. 
     */
    public void addMiss(){
        numberOfMisses++; 
        numberOfAccesses++; 
    }
    
    
    /**
     * Calculates the percent of hits. 
     */
    public void calculatePercentHits(){
        if((numberOfHits > 0) && (numberOfAccesses > 0)){
            double div = (double)numberOfHits/(double)numberOfAccesses; 
            hitRate = div * 100; 
        }
    }
    
    /**
     * Calculates the percent of misses. 
     */
    public void calculatePercentMisses(){
        if((numberOfMisses > 0) && (numberOfAccesses > 0)){
            double div = (double)numberOfHits/(double)numberOfAccesses; 
            missRate = div * 100; 
        }
    }
    
    /**
     * Calculates the ratio of hits to misses. 
     */
    public void calculateRatioHitsToMisses(){
        if((numberOfHits > 0 ) && (numberOfMisses > 0)){
            ratioHitsToMisses = (double)numberOfHits/(double)numberOfMisses; 
        }
    }
    
    /**
     * Calculates the ratio of misses to hits. 
     */
    public void calculateRatioMissesToHits(){
        if((numberOfHits > 0 ) && (numberOfMisses > 0)){
            ratioMissesToHits = (double)numberOfMisses/(double)numberOfHits; 
        }
    }
    
    /**
     * Retuns the number of hits. 
     * @return the numberOfHits. 
     */
    public int Number_Of_Hits(){
        return numberOfHits; 
    }
    
    /**
     * Returns the number of misses. 
     * @return numberOfMisses
     */
    public int Number_Of_Misses(){
        return numberOfMisses; 
    }
    
    /**
     * Returns the hit rate. 
     * @return hitRate. 
     */
    public double Hit_Rate(){
        calculatePercentHits(); 
        return hitRate; 
    }
    
    /**
     * Returns the miss rate 
     * @return missRate 
     */
    public double Miss_Rate(){
        calculatePercentMisses();
        return missRate; 
    }
    
    /**
     * Returns the hit miss ratio
     * @return ratioHitsToMisses. 
     */
    public double Hit_Miss_Ratio(){
        calculateRatioHitsToMisses();  
        return ratioHitsToMisses; 
    }
    
    /**
     * Returns the miss hit ratio. 
     * @return ratioMissesToHits. 
     */
    public double Miss_Hit_Ratio(){
        calculateRatioMissesToHits(); 
        return ratioMissesToHits; 
    }
    
    /**
     * Creates a string with all the statistics. 
     * @return A string with all the statistics. 
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append("Number of Hits: "); 
        builder = builder.append(Integer.toString(numberOfHits));
        builder = builder.append("\n"); 
        
        builder = builder.append("Number of Misses: "); 
        builder = builder.append(Integer.toString(numberOfMisses));
        builder = builder.append("\n"); 
        
        builder = builder.append("Total Accesses: "); 
        builder = builder.append(Integer.toString(numberOfAccesses));
        builder = builder.append("\n \n"); 
        
        builder = builder.append("Percent Hits: "); 
        builder = builder.append(Double.toString(hitRate));
        builder = builder.append("\n"); 
        
        builder = builder.append("Percent Miss: "); 
        builder = builder.append(Double.toString(missRate));
        builder = builder.append("\n \n"); 
        
        builder = builder.append("Ratio Hits to Misses:"); 
        builder = builder.append(Double.toString(ratioHitsToMisses)); 
        builder = builder.append("\n"); 
        
        builder = builder.append("Ratio Misses to Hits:"); 
        builder = builder.append(Double.toString(ratioHitsToMisses)); 
        builder = builder.append("\n"); 
        
        return builder.toString(); 
    }
}