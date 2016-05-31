package Cache;
import Utilities.CacheComponent; 
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Defines a class for a direct mapped cache. 
 * @author krclemmons
 */
public class DirectMappedCache extends CacheComponent{
    
    final boolean HIT = true; 
    final boolean MISS = false; 
    
    private int numberOfBlocks;                     ///< The number of entries in the cache. 
    private cacheEntry cacheEntries[];              ///< A list of the cacheEntries.  
    private ArrayList<ChangeListener> listeners;    ///< A list of the change listeners.
   
    /**
     * Create a DirectMappedCache with a number of entries. 
     * @param numberOfEntries the number of blocks in the cache. 
     */
    public DirectMappedCache(int numberOfEntries){
        numberOfBlocks = numberOfEntries; 
        cacheEntries = new cacheEntry[numberOfBlocks];  
        listeners = new ArrayList<ChangeListener>(); 
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntries[i] = new cacheEntry(i); 
        }
    }
    
    /**
     * Add a change listener to the class.
     * @param listener a listener to be added. 
     */
    public void addChangeListener(ChangeListener listener){
        listeners.add(listener); 
    }
    
    /**
     * Determines when a value is added, whether or not it is a hit. 
     * <p> Computs the location in the cache where the address is to be placed. </p> 
     * <p> If the addresses match, update the entries status as a hit and return true </p>
     * <p> If the addresses DO NOT MATCH, then update te entry with the new address, set the status to miss and return false </p>
     * @param address An address to be added. 
     * @return an index number in which the entry was added or found 
     */
    @Override
    public int addEntry(int address){
        int location = address % numberOfBlocks; 
        if(address == cacheEntries[location].getAddressValue()){
            cacheEntries[location].setHit(HIT);
            ChangeEvent event = new ChangeEvent(this); 
            for(ChangeListener listener: listeners){
                listener.stateChanged(event);
            }
            
            return location; 
        }
        else{
            cacheEntries[location].setAddress(address);
            cacheEntries[location].setHit(MISS);
            ChangeEvent event = new ChangeEvent(this); 
            for(ChangeListener listener: listeners){
                listener.stateChanged(event);
            }
            
            return location; 
        }
    }
    
    /**
     * Adds an address to the cache. 
     * <p> First takes in a string and then converts it into an Integer </p>
     * @param address An address number in string format. 
     * @return the locaion of the entry.
     */
    @Override 
    public int addEntry(String address){
        int addressNumber = Integer.parseInt(address); 
        //System.err.println(addressNumber); 
        int location = addressNumber  % numberOfBlocks; 
        
        if(cacheEntries[location].isAddressTheSame(addressNumber)){
            cacheEntries[location].setHit(HIT);
            return location; 
        }
        else{
            cacheEntries[location].setAddressValue(addressNumber);
            cacheEntries[location].setHit(MISS);
            return location; 
        }
    }
    
    /**
     * Defines an iterator for the array of cacheEntries. 
     * @return an iterator to the cachEntries. 
     */
    public Iterator<cacheEntry> getEntries(){
        return new Iterator<cacheEntry>(){
            int index = 0; 
            @Override
            public boolean hasNext() {
                return index < numberOfBlocks; 
            }

            @Override
            public cacheEntry next() {
                return cacheEntries[index++]; 
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }; 
    }
    
   
    
    /**
     * Parses a string with spaces and add the entries to the cache. 
     * @param entries A set of entries to be added to the list. 
     */
    public void addMultipleEntries(String entries){
        String token = "\n"; 
        String array[] = entries.split(token); 
        for(String toadd: array){
            int entr = addEntry(toadd); 
        }
    }
    
    /**
     * Locates the index in the cache where the address is being stored. 
     * @param address The address to be searched for. 
     * @return the corresponding index number. Returns -1 if not found. 
     */
    public int findAddressIndex(int address){ 
        int returnIndex = -1; 
        
        for(int i = 0; i < numberOfBlocks; i++){
            if(cacheEntries[i].getAddressValue() == address){
                returnIndex = i; 
            }
        }
        return returnIndex; 
    }
    
    /**
     * Gets the value based on the index in the cache. 
     * @param index
     * @return the cacheEntry with the assoicated index. If the entry is out of bounds, return a null entry.  
     */
    public cacheEntry getValueAt(int index){
        if((index < 0) || (index > numberOfBlocks)){
            return null; 
        }
        else{
            return cacheEntries[index]; 
        }
    }
    
    /**
     * The maximum number of entries in the cache. 
     * @return numberOfBlocks the number of blocks in the cache. 
     */
    @Override
    public int MAXCapacity() {
        return numberOfBlocks; 
    }
    
    
    /**
     * Goes through all the entries and resets the address equal to zero. 
     */
    @Override
    public void emptyCache() {
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntries[i].setAddress(0);
        }
    }
    
    /**
     * Gets the kind of cache the subclass is of. 
     * @return "Direct Mapped" 
     */
    @Override
    public String cacheType() {
        return "Direct Mapped"; 
    }
    
    public String printEntries(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append(String.format("%-12s%-12s%s\n","Index","Hit/Miss","Memory Address")); 
        for(int i = 0; i < numberOfBlocks; i++){
            builder = builder.append(String.format("%-12s%-12s%s\n",cacheEntries[i].getIndexDecimal(),cacheEntries[i].getHit(),cacheEntries[i].memoryFormatDecimalString()));
        }
        return builder.toString(); 
    }
    
    
}
