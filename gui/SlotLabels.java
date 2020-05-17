package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.SwingConstants;


import kalkyl.CurrentCell;
import kalkyl.SheetOfCells;



public class SlotLabels extends GridPanel {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 * Constructor parameters are rows,cols,listOfells,Current Slot
	 * 
	 * 
	 * 
	 * **/
    private List<SlotLabel>labelList;

    private SheetOfCells  sheet;
    private CurrentCell currentCell;
    

    	public SlotLabels(int rows, int cols, SheetOfCells sheet, CurrentCell currentCell ) {
    		
    		
    	
    	
    	

    	
        super(rows + 1, cols);
        

        this.currentCell = currentCell;
        this.sheet = sheet;

        labelList = new ArrayList<SlotLabel>(rows * cols);


        for (char ch = 'A'; ch < 'A' + cols; ch++) {
        	add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
        			SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
        	for (char ch = 'A'; ch < 'A' + cols; ch++) {


        		SlotLabel label = new SlotLabel(sheet,""  + ch + row,currentCell);
        		currentCell.addObserver(label);
        		sheet.addObserver(label);
        		
        		label.addMouseListener(new MouseAdapter() {
        	        public void mouseClicked(MouseEvent e) {
        	        	label.setBackground(Color.YELLOW); 
        	    		
        	    		currentCell.updateAddress(label.getAddress()); 
	
        	         }
        	     });
        		add(label);
        		labelList.add(label);

        	}
        }
        labelList.get(0).setBackground(Color.YELLOW);
        
    	}


	
    	
    	







}
