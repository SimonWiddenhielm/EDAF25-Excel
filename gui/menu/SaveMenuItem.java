package gui.menu;

import gui.StatusLabel;
import gui.XL;
import kalkyl.SheetOfCells;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
	private SheetOfCells sheet;
    public SaveMenuItem(XL xl, StatusLabel statusLabel, SheetOfCells sheet) {
        super(xl, statusLabel, "Save");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
    	
    	PrintWriter printer = new PrintWriter(path);
    	
    	try {
    		
    		Files.write(Paths.get(path),sheet.exportSheet().getBytes());
    		
    	}
    	catch(Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	
    	
    	
    	
        
    }

    protected int openDialog(JFileChooser fileChooser) {
    	
        return fileChooser.showSaveDialog(xl);
    }
}