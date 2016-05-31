package Utilities;

/**
 * Defines the base class for a memory address component. 
 * @author krclemmons
 */
public abstract class MemoryAddressComponent implements Cloneable {
    
    /**
     * A value to be stored as a memory address. 
     */
    protected int addressValue; 
    
    /**
     * Gets the associated integer value for the address. 
     * @return addressValue a value associated with the address. 
     */
    public int getAddressValue(){
        return addressValue; 
    }
    
    public void setAddressValue(int theAddress){
        addressValue = theAddress; 
    }
    
    /**
     * Reads the addressValue from a string. 
     * @param theAddress An address to be read from. 
     */
    public abstract void readAddressValue(String theAddress); 
    
    
    /**
     * Compares two objects. 
     * @param value An object in which to be compared with. 
     */ 
    @Override
    public boolean equals (Object value){
	MemoryAddressComponent v = (MemoryAddressComponent)value;
	return getClass().equals(v.getClass()) && isEqual(v);
    }
    
    /**
     * Gets the name of the type of subclass being used. 
     * @return The name of the subclass. 
     */
    public abstract String Type(); 
    
    /** 
     * @pre valueKind() == v.valueKind()
     * @Return true iff this value is equal to v, using a comparison
     * appropriate to the kind of value.
     */
    public abstract boolean isEqual (MemoryAddressComponent v);
    
    /**
     * Converts addressValue into string with format Mem[addressValue]
     * @return addressValue into string with format Mem[addressValueinDecimal]
     */
    public String memoryFormatDecimalString(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append("Mem["); 
        builder = builder.append(Integer.toString(addressValue)); 
        builder = builder.append("]"); 
        return builder.toString(); 
    }
    
    /**
     * Converts addressValue into string with format Mem[addressValueinHex]
     * @return addressValue into string with format Mem[addressValueinHex]
     */
    public String memoryFormatHexString(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append("Mem["); 
        builder = builder.append(Integer.toHexString(addressValue)); 
        builder = builder.append("]"); 
        return builder.toString(); 
    }
    
    /**
     * Converts addressValue into string with format Mem[addressValueinBinary]
     * @return addressValue into string with format Mem[addressValueinBinary]
     */
    public String memoryFormatBinaryString(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append("Mem["); 
        builder = builder.append(Integer.toBinaryString(addressValue)); 
        builder = builder.append("]"); 
        return builder.toString(); 
    }
    
    /**
     * Converts addressValue into string with format Mem[addressValueinOctal]
     * @return addressValue into string with format Mem[addressValueinOctal]
     */
    public String memoryFormatOctalString(){
        StringBuilder builder = new StringBuilder(); 
        builder = builder.append("Mem["); 
        builder = builder.append(Integer.toOctalString(addressValue)); 
        builder = builder.append("]"); 
        return builder.toString(); 
    }
    
    /**
     * Converts addressValue to a String. 
     * @return the addressValue in decimal form as a string. 
     */
    public String addressValueToDecimalString(){
        return Integer.toString(addressValue); 
    }
    
    /**
     * Converts addressValue to a hex String. 
     * @return the addressValue in hex form as a string. 
     */
    public String addressValueToHexString(){
        return Integer.toHexString(addressValue); 
    }
    
    /**
     * Converts addressValue to a binary String. 
     * @return the addressValue in binary form as a string. 
     */
    public String addressValueToBinaryString(){
        return Integer.toBinaryString(addressValue); 
    }
    
    /**
     * Converts addressValue to an octal String. 
     * @return the addressValue in octal form as a string. 
     */
    public String addressValueToOctalString(){
        return Integer.toOctalString(addressValue); 
    }
}
