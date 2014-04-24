package travis.pence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModifyString {

	private String orginalString; 
	private ArrayList<String> words = new ArrayList<String>();
	private String dividedInSyllables;
	private ArrayList<Alofono> listOfAlofonos = new ArrayList<Alofono>();
	private Map<String, Alofono> retrieveAlofonos = new HashMap<String, Alofono>();

	public ModifyString(){
	}
	
	//Seperate the string into seperate word tokens.
	public ArrayList<String> seperateWords(String st){
		ArrayList<String> seperateWords = new ArrayList<String>();

		String[] splits = st.split("\\s+");

		for (String s : splits){
			seperateWords.add(s);
		}
		return seperateWords; 
	}
	
	
	

	


	
}

