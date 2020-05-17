package kalkyl;

import java.util.*;

public class CurrentCell extends Observable {
	
	
	
	//Editor,SlotLabels Skall observera CurrentSlot.
	
	private String address;

	public CurrentCell(String address) {
		
		this.address = address;
		updateAddress(address);
		
	}     

	public void updateAddress(String newAddress) { 
		
		address = newAddress;
		setChanged(); 
        notifyObservers(); 

	}

	public String getAdress() {
		
		return address;
	}
	
	
	
	
}
