package travis.pence;

import java.util.ArrayList;

public class Fonema {
	private ArrayList<String> listOfAlofonos = new ArrayList<String>();
	private String fonema;
	
	Fonema(String f, ArrayList<String> al){
		this.fonema = f;
		this.listOfAlofonos = al;
	}
	
	public ArrayList<String> returnList(){
		return this.listOfAlofonos;
	}
	
	public String returnFirstAlofono(){
		return this.listOfAlofonos.get(1);
	}
	
	public String getFonema(){
		return this.fonema;
	}

}
