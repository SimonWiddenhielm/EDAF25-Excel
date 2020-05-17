package kalkyl;

import java.util.Observable;

import expr.Environment;
import expr.Expr;

public interface Cell {
	
	

	
	public double value(Environment env);
	
	public String toString(Environment env);
	
	
	
	

}
