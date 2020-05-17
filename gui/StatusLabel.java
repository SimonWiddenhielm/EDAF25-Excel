package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
/** 
 * Obs
 * 
 * 
 * 
 * 
 * 
 * **/

public class StatusLabel extends ColoredLabel implements Observer { //-> StatusLabel observser error massage and displays them
	
	
	
    public StatusLabel() {
    
    	
        super("asd", Color.WHITE);
        
        
        
    }

    
    public void update(Observable observable, Object object) {
    	
    	
        setText("");
        
        
    }
    
    
}