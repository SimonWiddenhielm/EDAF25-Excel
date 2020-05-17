package kalkyl;


import java.util.Observable;

import expr.Environment;


public class StringCell extends Observable implements Cell {
	
	private String comment;

	
	public StringCell(String initialComment) {
		comment = initialComment;
		
		
	}
	public double value(Environment env) {
		return 0;
		
		
	
	}


	@Override
	public String toString(Environment env) {
		
		return comment;
		
	}
	
	
	
	

	
	
	
	

}
