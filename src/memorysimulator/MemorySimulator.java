package memorysimulator;

import Cache.DirectMappedCache;
import Cache.cacheEntry;
import DirectMappedCacheGUIs.DirectMappedCacheGUI;
import java.util.Iterator;

/**
 *
 * @author krclemmons
 */
public class MemorySimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DirectMappedCacheGUI testGUI = new DirectMappedCacheGUI(false);
       testGUI.setTitle("Direct Mapped Cache Simulator");
       testGUI.setSize(1000, 500);
       testGUI.setResizable(false);
       testGUI.setVisible(true);
    }
    
}
