package travis.pence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoneticDevices {
	
	private String orginalString; 
	private String stringWithFonemas;
	private String stringWithAlfonos;
	
	private ArrayList<Alofono> listOfAlofonos = new ArrayList<Alofono>();
	private ArrayList<Fonema>  listOfFonemas = new ArrayList<Fonema>();
	private Map<String, Alofono> retrieveAlofonos = new HashMap<String, Alofono>();
	private Map<String,  ArrayList<String>> retrieveFonemas = new HashMap<String,  ArrayList<String>>();
	
	private ArrayList<String> words = new ArrayList<String>();
	
	private ModifyString stringEditor = new ModifyString();
	
	public FoneticDevices(String s){
		this.orginalString = s;
		//this.loadAlofonos();
		this.loadFonemas();
		this.words =stringEditor.seperateWords(s);
		this.TranscripciónFonetica();
	}
	
	public void TranscripciónFonetica(){

		StringBuilder foneticString = new StringBuilder(this.orginalString);
		
		
		for (int i = 0; i < foneticString.length()-1; i++){
			char previousChar;
			char nextChar;
			char anotherChar;
			char currentChar = foneticString.charAt(i);
			if(i != 0){
				previousChar = foneticString.charAt(i-1);
			}
			else{
				previousChar = '0';
			}
			if ((i+1) <= foneticString.length()-1){
				nextChar = foneticString.charAt(i+1);
				
			}
			else{
				nextChar = '0';
			}
			
			if((i+2) <= foneticString.length()-1){
				anotherChar = foneticString.charAt(i+2);
			}
			else{
				anotherChar = '0';
			}
			
			/*“c” es representado por /s/ cuando la “c” va delante de “e” o “i”
			 * es representado por /k/ cuando va en frente de “a” “o” “u”,
			 * delante de cualquier consonante, o al final de palabra.
			 */
			if (currentChar == 'c'){
				if (nextChar == 'i' || nextChar == 'e'){
					foneticString.setCharAt(i, 's');
				}
				else if (nextChar =='h'){
					foneticString.replace(i, i+1, "č");
					foneticString.deleteCharAt(i+1);
				}
				else{
					foneticString.setCharAt(i, 'k');
				}
			}
			/*
			 * “v” es representado por /b/ siempre.
			 */
			else if (currentChar == 'v'){
				foneticString.setCharAt(i, 'b');
			}
			else if ((currentChar == 'l') && (nextChar == 'l')){
				foneticString.replace(i, i+1, "j");
			}
			else if (currentChar == 'z'){
				foneticString.setCharAt(i, 's');
			}
			
			
		}
		
		this.stringWithFonemas = foneticString.toString();
	}
	
	
	public String returnFoneticTransciption(){
		return this.stringWithFonemas;
	}
	
	
	
	
	
	
	
	
	
	//Load the fonemas and alofonos. Uses text files.
	private void loadFonemas(){
		File file = new File("fonemas.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String curLine = scanner.nextLine().trim();
			ArrayList<String> partList = stringEditor.seperateWords(curLine);
			String firstTerm = partList.get(0);
			partList.remove(0);
			this.listOfFonemas.add(new Fonema(firstTerm, partList));
			for (Fonema f :listOfFonemas){
				retrieveFonemas.put(f.getFonema(), f.returnList());
			}
		}
	}
	private void loadAlofonos(){
		File file = new File("alofonos.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {
			//Get next line in the Alofonos.txt and seperate it in words seperated by spaces.
			String curLine = scanner.nextLine().trim();
			ArrayList<String> partList = stringEditor.seperateWords(curLine);
			//Add a new Alofono to the list of alofonos.
			this.listOfAlofonos.add(new Alofono(partList.get(0),partList.get(1),partList.get(2),partList.get(3)));
			for (Alofono a : listOfAlofonos){
				System.out.print(a.getAlofono()+"\n");
				retrieveAlofonos.put(a.getAlofono(), a);
			}
		}
	}
}
