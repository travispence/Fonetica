package travis.pence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, Enter a string");
		ArrayList<String> list = new ArrayList<String>();
		String input;

		Scanner scanIn = new Scanner(System.in);
		input = scanIn.nextLine();

		scanIn.close();
		System.out.print("Input was "+input+"\n");
		Palabra word = new Palabra(input.trim());
		
		//FoneticDevices f = new FoneticDevices(input);
		//System.out.print("The fonetic transcription is \n"+f.returnFoneticTransciption());
		
		System.out.print("Word is "+ input+" and it is: "+word.getType()+"\n");
		System.out.print("The syllables are: "+word.getSyllables());
		
		
		/*
		ArrayList<Alofono> listOfAlofonos = new ArrayList<Alofono>();
		Map<String, Alofono> retrieveAlofonos = new HashMap<String, Alofono>();


		File file = new File("alofonos.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {
			String curLine = scanner.nextLine().trim();
			ModifyString m = new ModifyString();
			ArrayList<String> partList = m.seperateWords(curLine);
			listOfAlofonos.add(new Alofono(partList.get(0),partList.get(1),partList.get(2),partList.get(3)));

		}

		for (Alofono a : listOfAlofonos){
			System.out.print(a.getAlofono()+"\n");
			retrieveAlofonos.put(a.getAlofono(), a);
		}




		System.out.print("ð: "+retrieveAlofonos.get("ð").getAlofono()+", "+retrieveAlofonos.get("ð").getModo());
	} 
		 */

	}
}







