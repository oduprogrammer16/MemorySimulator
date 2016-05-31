package DirectMappedCacheGUIs;

import javax.swing.table.AbstractTableModel;

/**
 * Defines the table model for representing the contents in the cache.
 * <p> The class extends an Abstract Table Model <p>
 * @author krclemmons
 */
public class DirectMappedCacheTableModel extends AbstractTableModel {
    String columnNames[] = {"Index", "Hit/Miss", "Memory Address"}; ///< The names of the columns
    private int numberOfRows;                                       ///< The number of rows in the cache. 
    private int numberOfColumns = 3;                                ///< The number of columns in the cache. 
    
    private Object[][] data; ///< A 2D array in which the data from the cache is located. 
    
    /**
     * Creates a new Table for the direct mapped cache and sets the initial state with the default value. 
     * @param nRows The number of rows that are in the cache. 
     */
    public DirectMappedCacheTableModel(int nRows){
        numberOfRows = nRows; 
        data = new Object[numberOfRows][numberOfColumns]; 
        for(int i = 0; i < numberOfRows; i++){
            data[i][0] = new String(Integer.toString(i)); 
            data[i][1] = new String("Miss"); 
            data[i][2] = new String("Mem[0]"); 
        } 
    }
    
    /**
     * Gets the number of rows. 
     * @return numberOfRows 
     */
    @Override
    public int getRowCount() {
        return numberOfRows; 
    }

    /**
     * Gets the number of columns 
     * @return the numberOfColumns in the cache. 
     */
    @Override
    public int getColumnCount() {
        return numberOfColumns; 
    }
    
    /**
     * Returns a value associated with a row and column
     * @param rowIndex the row in which the data is located. 
     * @param columnIndex the column in which the data is located. 
     * @return The data associated with the rowNumber and columnNumber 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (String)data[rowIndex][columnIndex]; 
    }
    
    /**
     * Gets the name of the column with an associated value. 
     * @param col the columnNumber in which the value is stored.
     * @return the name of the column. 
     */
    @Override
    public String getColumnName(int col){
        return columnNames[col].toString(); 
    }
    
    /**
     * Sets the value in a cell in the table and then update the table in the gui.
     * @param object The object to set data to. 
     * @param rowIndex The corresponding row in which the data is to be stored. 
     * @param columnIndex The corresponding column in which the data is to be stored. 
     */
    @Override
    public void setValueAt(Object object, int rowIndex, int columnIndex){
        data[rowIndex][columnIndex] = (String)object; 
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    /**
     * Ensures that no cell is editable 
     * @param row The row in which a cell is located. 
     * @param col The column in which the cell is located. 
     * @return false which means that the cell is not editable. 
     */
    @Override 
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false; 
    }
    
}
