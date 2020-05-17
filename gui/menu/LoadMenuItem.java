package gui.menu;

import gui.StatusLabel;
import gui.XL;
import kalkyl.SheetOfCells;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	
	
	private SheetOfCells sheet;
	
    public LoadMenuItem(XL xl, StatusLabel statusLabel, SheetOfCells sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) {
    	try {
    	
    
    	Scanner reader = new Scanner(Paths.get(path));
    	
    	
    	
  	 
  	  
  	  String LineRead;
  	  String adr,expr;
  	  	sheet.removeAll();
        while ( reader.hasNext()) {
        	
        LineRead = reader.next();
      	  String[] s = LineRead.split("=");
      	  adr = s[0];
      	  expr = s[1];
 
      	 System.out.println(adr + " " + expr);
      	 sheet.insert(adr, expr);
      	 
      	 
      	 
        }
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
      	
      	
        }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}