package Cache;

import Utilities.MemoryAddressComponent;

/**
 * A cache entry is identified by it's index number. 
 * 
 * @author krclemmons
 */
public class cacheEntry extends MemoryAddressComponent{
    private int indexNumber; ///< The number corresponding to the position where the entry is located in the cache. 
    private boolean hit;     ///< Whether or not the last access resulted in a hit or a miss. 
    
    /**
     * The Default constructor. 
     * <p> Initializes the index number to zero and hit to false. 
     */
    public cacheEntry(){
        indexNumber = 0; 
        hit = false; 
    }
    
    /**
     * The defined constructor. 
     * <p> Must have an assigned index number when the object is created. And it cannot be changed</p>
     * @param theIndex The assigned index number. 
     */
    public cacheEntry(int theIndex){
        indexNumber = theIndex;
        hit = false; 
    }
    
    /**
     * Sets the indexNumber of the cache entry. 
     * @param theIndex A value to set indexNumber to. 
     */
    public void setIndexNumber(int theIndex){
        indexNumber = theIndex; 
    }
    
    /**
     * Sets the addressNumber that is being mapped to the cache entry. 
     * @param addressNum An address number to be mapped to. 
     */
    public void setAddress(int addressNum){
        addressValue = addressNum; 
    }
    
    /**
     * Checks to see if the addressNumber is the same. 
     * @param addressNum
     * @return true if the address is the same. 
     */
    public boolean isAddressTheSame(int addressNum){
        return (this.addressValue == addressNum); 
    }
    
    /**
     * Gets the number associated with the integer. 
     * @return indexNumber the index number associated with the the cache entry
     */
    public int getIndexValue(){
        return indexNumber; 
    }
    
    /**
     * Reads an address. 
     * @param theAddress an address to be read.  
     */
    @Override
    public void readAddressValue(String theAddress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns the type of MemoryAddressComponent. 
     * @return "Cache Entry
     */
    @Override
    public String Type() {
        return "Cache Entry"; 
    }
    
    /**
     * Determines whether or not two entries are the same by comparing their indexes. 
     * @param v An object that MUST BE OF cacheEntry type 
     * @return Whether or not the indexes are the same. 
     */
    @Override
    public boolean isEqual(MemoryAddressComponent v) {
        if(v instanceof cacheEntry){
            cacheEntry toCompare = (cacheEntry) v; 
            if(toCompare.getIndexValue() == this.getIndexValue()){
                return true; 
            }
            else{
                return false; 
            }
        }
        else{
            return false; 
        }
    }
    
    /**
     * Sets whether or not this entry has a hit or miss. 
     * @param HIT Whether or not the value is a hit. 
     */
    public void setHit(boolean HIT){
        hit = HIT; 
    }
    
    /**
     * Returns a string indicating if the entry is a hit. 
     * @return Whether or not a hit has occured.
     */
    public String getHit(){
        if(hit){
            return "Hit"; 
        }
        else{
            return "Miss"; 
        }
    }
    /**
     * Gets the index as a decimal in string format.  
     * @return index in decimal in string format. 
     */
    public String getIndexDecimal(){
        return Integer.toString(indexNumber); 
    }
    
    /**
     * Gets the index as a decimal in binary string format.  
     * @return index in binary in string format. 
     */
    public String getIndexBinary(){
        return Integer.toBinaryString(indexNumber); 
    }
    
    /**
     * Gets the index as a decimal in string format.  
     * @return index in hex in string format. 
     */
    public String getIndexHex(){
        return Integer.toHexString(indexNumber); 
    }
    
    /**
     * Gets the index as a decimal in string format.  
     * @return index in octal in string format. 
     */
    public String getIndexOctal(){
        return Integer.toOctalString(indexNumber); 
    }
    
}
