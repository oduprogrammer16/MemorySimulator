package Utilities;

/**
 * Defines an abstract class for a variety of cache types. 
 * @author krclemmons
 */
public abstract class CacheComponent {
    protected int numberOfBlocks; 
    protected int numberOfSets; 
    
    
    /**
     * Add an entry as a string in the cache. 
     * <p> Function needs to convert the string into a number value</p>
     * @param address The address to be added. 
     * @return the location in which the entry was added. 
     */
    public abstract int addEntry(String address); 
    
    /**
     * Add an entry to the cache. 
     * @param address
     * @return the location in which the entry was added. 
     */
    public abstract int addEntry(int address);   
    
    /**
     * How many entries can the cache hold. 
     * @return numberOfBlocks
     */
    public abstract int MAXCapacity(); 
    
    /**
     * Clear all the addressValues in the cache. 
     */
    public abstract void emptyCache(); 
    
    /**
     * What kind of cache is this? 
     * @return the type of the cache. 
     */
    public abstract String cacheType(); 
    
}
