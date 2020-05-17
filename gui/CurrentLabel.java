package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import kalkyl.CurrentCell;

public class CurrentLabel extends ColoredLabel implements Observer {
	
	private String adress;
	private CurrentCell currentCell;
    public CurrentLabel(String Adress, CurrentCell currentCell) {
        super("A1", Color.WHITE);
        
        this.currentCell = currentCell;
        this.adress = adress;
    }
    
    

	@Override
	public void update(Observable o, Object arg) {
		
		
			setText(currentCell.getAdress());
			
			
		
		
	}
	
	public void setAdress(String adr) {
		adress = adr;
	}
}