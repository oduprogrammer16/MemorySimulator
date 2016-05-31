package DirectMappedCacheGUIs;
import Cache.*; 
import Utilities.Statistics;
import Utilities.UnitNames;
import Utilities.Statistics;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author krclemmons
 */
public class DirectMappedCacheGUI extends JFrame  {
    private final int DEFAULT_CACHE_SIZE = 32; 
    private boolean inApplet; 
    
    
    private DirectMappedCacheContents cacheContents; 
    private JTextArea statisticsArea; 
    private JPanel leftPanel; 
    
    private Statistics cacheStatistics; 
    private String hitMissStat; 
    private JPanel bottomPanel; 
    private JButton addEntry; 
    private JButton resetCache; 
     
    private JLabel base; 
    private ButtonGroup baseSelectors; 
    private JRadioButton decimalSelection; 
    private JRadioButton binarySelection; 
    private JRadioButton octalSelection; 
    private JRadioButton hexcidecimalSelection; 
    
    private Choice numberFormat; 
    
    public DirectMappedCacheGUI(boolean INAPPLET){
        inApplet = INAPPLET; 
        getContentPane().setLayout(new BorderLayout());
        
        // Set up the statistics panel 
        leftPanel = new JPanel();
        cacheStatistics = new Statistics(); 
        statisticsArea = new JTextArea(cacheStatistics.toString());
        statisticsArea.setEditable(false);
        statisticsArea.setBackground(this.getBackground());
        leftPanel.add(statisticsArea); 
        getContentPane().add(leftPanel, BorderLayout.WEST); 
        
        // Create an instance of the cache contents and add it to the frame 
        cacheContents = new DirectMappedCacheContents(DEFAULT_CACHE_SIZE); 
        
        
        add(cacheContents);    
        
        // Define the bottom pannel. 
        bottomPanel = new JPanel(); 
        JPanel rightPanel = new JPanel(); 
        JLabel addEntry2 = new JLabel("Add Entry: "); 
        final JTextField enterEntry = new JTextField(10); 
        // Create the addEntry button
        addEntry = new JButton("Add an Entry"); 
        addEntry.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //JFrame frame = new JFrame(); 
                //String addressToAdd = JOptionPane.showInputDialog(frame,"Enter an address"); 
                hitMissStat = cacheContents.addEntry(enterEntry.getText());
                if(hitMissStat.equals("Hit")){
                    cacheStatistics.addHit();
                }
                if(hitMissStat.equals("Miss")){
                    cacheStatistics.addMiss();
                }
                enterEntry.setText("");
                statisticsArea.setText(cacheStatistics.toString());
            }
        });
        rightPanel.add(addEntry2); 
        rightPanel.add(enterEntry); 
        rightPanel.add(addEntry); 
        getContentPane().add(rightPanel, BorderLayout.EAST); 
        
        // Create a selector to choose between decimal,binary, octal and hexidecimal numbers. 
        // TODO Will need to do some threading here! 
        base = new JLabel("Base: "); 
        bottomPanel.add(base); 
        
        // Create the base selectors
        
        baseSelectors = new ButtonGroup(); 
        decimalSelection = new JRadioButton("Decimal"); 
        decimalSelection.setSelected(true);
        decimalSelection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cacheContents.switchNumbersToDecimal();
            }
            
        });
        baseSelectors.add(decimalSelection);
        bottomPanel.add(decimalSelection); 
        
        binarySelection = new JRadioButton("Binary"); 
        binarySelection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cacheContents.switchNumbersToBinary();
            }
            
        });
        baseSelectors.add(binarySelection);
        bottomPanel.add(binarySelection,null); 
        
        octalSelection = new JRadioButton("Octal"); 
        octalSelection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               cacheContents.switchNumbersToOctal();
            }
            
        });
        baseSelectors.add(octalSelection);
        bottomPanel.add(octalSelection); 
        
        hexcidecimalSelection = new JRadioButton("Hexidecimal");
        hexcidecimalSelection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cacheContents.switchNumbersToHexidecimal();
            }
            
        });
        baseSelectors.add(hexcidecimalSelection);
        bottomPanel.add(hexcidecimalSelection); 
        
        
        // Create the reset button. 
        resetCache = new JButton("Reset Cache"); 
        resetCache.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                cacheContents.clearCacheContents();
            }
        });
        bottomPanel.add(resetCache); 
        
        // Add the bottom panel to the frame. 
        getContentPane().add(bottomPanel, BorderLayout.SOUTH); 
        
        
        // Add a window listener for the close operation of the DirectMappedCache GUI. 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (inApplet)
                    setVisible(false);
                else
                    System.exit(0);
            }
        });
    }
}

