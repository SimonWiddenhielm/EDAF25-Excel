


package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import kalkyl.CurrentCell;
import kalkyl.SheetOfCells;

public class SheetPanel extends BorderPanel {
	private SlotLabels slot;
    public SheetPanel(int rows, int columns, SheetOfCells sheet, CurrentCell currentCell) {
    	slot = new SlotLabels(rows,columns,sheet,  currentCell);
    	
        
    	add(WEST, new RowLabels(rows));
        add(CENTER, slot);
        
       
    }
    
    
}
