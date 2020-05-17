package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.Editor;
import kalkyl.CurrentCell;
import kalkyl.SheetOfCells;

class ClearMenuItem extends JMenuItem implements ActionListener {
	
	private SheetOfCells sheet;
	private CurrentCell currCell;
	
    public ClearMenuItem(SheetOfCells sheet, CurrentCell currCell) {
        super("Clear");
        addActionListener(this);
        
        this.sheet = sheet;
        this.currCell = currCell;
    }

    public void actionPerformed(ActionEvent e) {
    	System.out.println("asd");
        sheet.remove(currCell.getAdress());
        currCell.updateAdress("");
    }
}