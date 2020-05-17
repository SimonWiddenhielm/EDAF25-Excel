package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;


import kalkyl.CurrentCell;

import kalkyl.SheetOfCells;

public class Editor extends JTextField implements Observer {

	private CurrentLabel currentLabel; //Current "slot" chosen, chosen upon MouseEvent-> Mouseclick, the expression typed in the editor class(JTextField) from keyboard will be a value or equation 
	private SlotLabels grid; //   (compiled as of either another slot or combination of 2 or more ) or comment. This expression is dipslayed in the  currentLabel(marked.YELLOW) obj
	private CurrentCell currCell;
	private String currentAdress;
	private SheetOfCells sheet;


	public Editor( SheetOfCells sheet,CurrentCell currCell ) {
		setBackground(Color.WHITE);
		this.grid = grid;
		this.currCell = currCell;
		this.sheet = sheet;

		addActionListener(e -> {
			sheet.insert(currCell.getAdress(), getText());
		}); //Sends the input to model logic for arithmetic operations and standard evaluation.
	}


	@Override
	public void update(Observable o, Object arg) { // This method is called whenever the observed object is changed. An application calls an Observable object's notifyObservers method to have all the object's observers notified of the change.

		currentAdress = currCell.getAdress();

		if(sheet.contains(currentAdress)) {
			if(!sheet.isExpr(currentAdress)) {
				setText("#" + sheet.StringRepresentation(currentAdress));
			} else {
				setText(sheet.StringRepresentation(currentAdress));
			}
			
		} else {
			setText("");
		}
	}
	
}