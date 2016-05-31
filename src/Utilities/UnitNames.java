package Utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a set of unit names, their abbreviations and the corresponding exponent values. 
 * @author krclemmons
 */
public final class UnitNames {
    public static String baseNames[] = {"Decimal", "Binary", "Hexidecimal","Octal"}; 
    public static String names[] = {"byte", 
                                    "kilobyte", "megabytes", "gigabyte", 
                                    "terrabyte", "petabyte", "exabyte",
                                    "zettabyte", "yottabyte"};
    
    
    public static Map<String, Integer> namesToExponents; 
    public static Map<String, Integer> abbreviationsToExponents; 
    private UnitNames(){
        namesToExponents = new HashMap<String,Integer>(); 
        namesToExponents.put("byte", 3); 
        namesToExponents.put("kilobyte", 10); 
        namesToExponents.put("megabyte",20); 
        namesToExponents.put("gigabyte", 30); 
        namesToExponents.put("terrabyte", 40); 
        namesToExponents.put("petabyte", 50); 
        namesToExponents.put("exabyte", 60);
        namesToExponents.put("zettabyte", 70);
        namesToExponents.put("yottabyte", 80); 
        
        abbreviationsToExponents = new HashMap<String, Integer>(); 
        
        abbreviationsToExponents.put("byte", 3); 
        abbreviationsToExponents.put("KB", 10); 
        abbreviationsToExponents.put("MB",20); 
        abbreviationsToExponents.put("GB", 30); 
        abbreviationsToExponents.put("TB", 40); 
        abbreviationsToExponents.put("PB", 50); 
        abbreviationsToExponents.put("EB", 60);
        abbreviationsToExponents.put("ZB", 70);
        abbreviationsToExponents.put("YB", 80); 
        
        
    }
    
    public static int getUnitExponent(String unitName){
        String find = unitName.toLowerCase();
        
        if(namesToExponents.containsKey(find)){
            return namesToExponents.get(find); 
        }
        else{
            return -1; // unit Does not exist or is spelled incorrectly. 
        }
    }
    
    public static int getAbbreviationExponent(String unitAbbrev){
        String find = unitAbbrev.toUpperCase();
        
        if(abbreviationsToExponents.containsKey(find)){
            return abbreviationsToExponents.get(find); 
        }
        else{
            return -1; // unit Does not exist or is spelled incorrectly. 
        }
    }
    
    //public int 
    
}
