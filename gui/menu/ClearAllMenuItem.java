package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.Editor;
import kalkyl.SheetOfCells;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private SheetOfCells sheet;
	private Editor editor;
	
    public ClearAllMenuItem(SheetOfCells sheet, Editor editor) {
        super("Clear all");
        addActionListener(this);
        this.sheet = sheet;
        this.editor = editor;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.removeAll();
            
    }
}