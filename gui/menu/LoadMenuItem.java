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
import java.util.Scanner;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	private SheetOfCells sheet;
    public LoadMenuItem(XL xl, StatusLabel statusLabel, SheetOfCells sheet) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) {
    	try {
    	File file = new File(path);
    	
    	
    	Reader inputString = new StringReader(path);
    	BufferedReader reader = new BufferedReader(inputString);
    
    	
  	 
  	  
  	  String LineRead;
  	  
  	
        while ((LineRead = reader.readLine()) != null) {
      	  String[] s = LineRead.split("=");
      	  String adr = s[0];
      	 
      	  
      	  
      	  System.out.println(adr + " = " );
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