package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import kalkyl.CurrentCell;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel,String address, CurrentCell currentCell) {
    	
    	
    	CurrentLabel currLabel = new CurrentLabel(address,currentCell);
    	currentCell.addObserver(currLabel);
        add(WEST,currLabel );
        add(CENTER, statusLabel);
    }
}