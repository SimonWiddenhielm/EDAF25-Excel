package kalkyl;

import expr.Environment;
import expr.Expr;

public class ExprCell implements Cell {
	
	
	public Expr expression;
	
	public ExprCell(Expr expression) {
		this.expression = expression;
	}
	
	@Override
	public double value(Environment env) {
		
		return expression.value(env);
	}

	@Override
	public String toString(Environment env) {
	
		return expression.toString();
	}
	
	

}
