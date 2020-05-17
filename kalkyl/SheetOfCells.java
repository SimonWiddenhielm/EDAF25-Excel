package kalkyl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class SheetOfCells extends Observable implements Environment{
	
	
	private HashMap<String,Cell>sheet;

	public SheetOfCells () {
	
		sheet = new HashMap<>();
			
	}
	
	public boolean insert(String adress, String expr) {
		Cell cell;

		if (expr.charAt(0) == '#') {
			cell = new StringCell(expr.substring(1));
			sheet.put(adress, cell);
			System.out.println(sheet.get(adress).toString(this));
			setChanged();
			notifyObservers();
			return true;
		} else {
			ExprParser parser = new ExprParser();
			try {
				Expr expression = parser.build(expr);
				
				
				
				
				
				cell = new ExprCell(expression);
				sheet.put(adress, cell);				
				
				
				System.out.println(expression);
				System.out.println(sheet.get(adress).value(this));
				
				setChanged();
				notifyObservers();
				return true;
				
			}

			catch (IOException e) {

			}

			//System.out.println(sheet.get(adress).toString(this));
			
			return true;

		}
	}
	
	public void removeCell(String adress) {
		
		sheet.clear();
		setChanged();
        notifyObservers();
		
	}


	@Override
	public double value(String adress) {
		
		
		if(!sheet.containsKey(adress)) {
			
			throw new NullPointerException();
			
		}
		
		return sheet.get(adress).value(this);
		
	}
	
	
	public String StringRepresentation(String address) {
		
		
		if(!sheet.containsKey(address)) {
			
			throw new NullPointerException();
		}
		
		return sheet.get(address).toString(this);
	}
	
	
	public void remove(String adress) {
		
		
		sheet.remove(adress);
		setChanged();
        notifyObservers();
		
		
	}
	
	public void removeAll() {
		sheet.clear();
		setChanged();
        notifyObservers();
	}
	
	public boolean contains(String address) {

		return sheet.containsKey(address);
		
	}
	public String exportSheet() {
		
		StringBuilder sb = new StringBuilder();
		
		for (String adr : sheet.keySet()) {
			
			
			sb.append(adr + "=" + sheet.get(adr).toString(this) + "\n");
			
			
		}
		
		return sb.toString();
	}
		
	
		public String textValue(String adr) {
			if(sheet.containsKey(adr)) return Double.toString(sheet.get(adr).value(this));
			
			return "";
		}
		
		public boolean isExpr(String address) {
			return sheet.get(address) instanceof ExprCell;
		}
}
	
