package DirectMappedCacheGUIs;
import javax.swing.*; 
import java.awt.*; 
import Cache.DirectMappedCache; 
import Cache.cacheEntry;

/**
 * Defines a GUI panel that is used to view the contents in a directMapped cache
 * @author krclemmons
 */
public class DirectMappedCacheContents extends JPanel{
    private DirectMappedCache directMappedCache; 
    private int numberOfBlocks; 
    
    private JTable cacheContents;
    private JScrollPane scrollPane; 
    
    /**
     * Creates a new direct mapped cache with a certain number of blocks.
     * @param nBlocks The number of blocks in the cache.
     */
    public DirectMappedCacheContents(int nBlocks){
        numberOfBlocks = nBlocks; 
        directMappedCache = new DirectMappedCache(numberOfBlocks); 
        
        cacheContents = new JTable(new DirectMappedCacheTableModel(numberOfBlocks)); 
        cacheContents.setGridColor(Color.gray);
        cacheContents.setShowHorizontalLines(true);
        cacheContents.setShowGrid(true);
        cacheContents.setShowVerticalLines(true);
       
        
        scrollPane = new JScrollPane(cacheContents); 
        
        add(scrollPane); 
        
    }
    
    public String addEntry(String address){
        int location = directMappedCache.addEntry(address); 
        cacheEntry entr = directMappedCache.getValueAt(location); 
        modifyMissColumn(entr.getHit(),location); 
        modifyAddressColumn(entr.memoryFormatDecimalString(), location); 
        return entr.getHit(); 
    }
    
    public void modifyMissColumn(String miss, int rowNumber){
        cacheContents.setValueAt(miss, rowNumber, 1);
    }
    
    public void modifyAddressColumn(String addr, int rowNumber){
        cacheContents.setValueAt(addr, rowNumber, 2);
    }
    
   
    
    public void switchNumbersToDecimal(){
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntry entr = directMappedCache.getValueAt(i); 
            cacheContents.setValueAt(entr.getIndexDecimal(), i, 0);
            cacheContents.setValueAt(entr.memoryFormatDecimalString(), i, 2);
        }
    } 
    
    public void switchNumbersToBinary(){
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntry entr = directMappedCache.getValueAt(i); 
            cacheContents.setValueAt(entr.getIndexBinary(), i, 0);
            cacheContents.setValueAt(entr.memoryFormatBinaryString(), i, 2);
        }
    }
    
    public void switchNumbersToHexidecimal(){
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntry entr = directMappedCache.getValueAt(i); 
            cacheContents.setValueAt(entr.getIndexHex(), i, 0);
            cacheContents.setValueAt(entr.memoryFormatHexString(), i, 2);
        }
    }
    
    public void switchNumbersToOctal(){
        for(int i = 0; i < numberOfBlocks; i++){
            cacheEntry entr = directMappedCache.getValueAt(i); 
            cacheContents.setValueAt(entr.getIndexOctal(), i, 0);
            cacheContents.setValueAt(entr.memoryFormatOctalString(), i, 2);
        }
    }
    
    public void clearCacheContents(){
        directMappedCache.emptyCache();
        for(int i = 0; i < numberOfBlocks; i++){
            cacheContents.setValueAt("Miss", i, 1);
            cacheContents.setValueAt("Mem[0]", i, 2);
        }
    }
}
