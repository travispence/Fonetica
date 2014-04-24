package travis.pence;

import java.util.ArrayList;
import java.util.Collections;

public class Palabra {
	private StringBuilder word;
	private String type;
	private ArrayList<String> syllables = new ArrayList<String>();


	public Palabra(String s){
		this.word = new StringBuilder(s);
		this.type = this.determineType();
		this.syllables = this.divideInSyllables();

	}


	private ArrayList<String> divideInSyllables(){
		char[] v = {'a', 'e', 'i','o','u','y'};
		ArrayList<String> syllables = new ArrayList<String>();

		ArrayList<String> neverSeperate = new ArrayList<String>();
		Collections.addAll(neverSeperate, "pl","bl","gl","cl","gl","pr","br","fr","cr","gr","tr","dr","ch","ll");

		ArrayList<String> alwaysSeperate = new ArrayList<String>();
		Collections.addAll(alwaysSeperate,  "nt", "st", "ns", "sc", "mp", "ld", "rt",  "tl", "rg");

		ArrayList<Character> vowels =  new ArrayList<Character>();
		for (char c : v){
			vowels.add(c);
		}
		int length = this.word.length() - 1;
		char currentChar;
		char nextChar;
		char otroChar;
		char otraCharDeNuevo;

		int startOfSubstring = 0;
		for (int i = 0; i < length;){
			if(i == length){
				currentChar = this.word.charAt(i);
				nextChar = '0';
				otroChar = '0';
				otraCharDeNuevo = '0';
			}
			else if (i == length - 1){
				currentChar = this.word.charAt(i);
				nextChar = this.word.charAt(i+1);
				otroChar = '0';
				otraCharDeNuevo = '0';
			}
			else if (i == length -2){
				currentChar = this.word.charAt(i);
				nextChar = this.word.charAt(i+1);
				otroChar = this.word.charAt(i+2);
				otraCharDeNuevo = '0';
			}
			else{
				currentChar = this.word.charAt(i);
				nextChar = this.word.charAt(i+1);
				otroChar = this.word.charAt(i+2);
				otraCharDeNuevo = this.word.charAt(i+3);

			}

			if(vowels.contains(currentChar)){

				if(nextChar == '0'){
					//The nextChar is null 
					syllables.add(this.word.substring(startOfSubstring, length+1));
					i = length;
				}
				else if (vowels.contains(nextChar)){
					//The next character is a vowel
					i = i + 1;
				}
				else{
					//The next char is a consonant
					if(otroChar == '0'){
						//The otroChar is null and we should exit the loop.
						i = length;
					}
					else if(vowels.contains(otroChar)){
						syllables.add(this.word.substring(startOfSubstring, i+1));
						startOfSubstring = i + 1;
						i = i +2;
					}
					else{
						//The otro char was also a consonant
						String s = new StringBuilder().append(nextChar).append(otroChar).toString();
						if(neverSeperate.contains(s)){
							syllables.add(this.word.substring(startOfSubstring, i+1));
							startOfSubstring = i+1;
							i = i+1;
						}
						else if (alwaysSeperate.contains(s)){

							if ((s.equals("ns")) && ((!vowels.contains(otraCharDeNuevo)))){
								syllables.add(this.word.substring(startOfSubstring, i+3));
								startOfSubstring = i+3;
								i = i+3;
							}
							else{
								syllables.add(this.word.substring(startOfSubstring, i+2));
								startOfSubstring = i+2;
								i = i+2;
							}
						}
						else{
							if((s.equals("bs"))){
								syllables.add(this.word.substring(startOfSubstring, i+3));
								startOfSubstring = i+3;
								i = i+3;

							}
							else{
								syllables.add(this.word.substring(startOfSubstring, i+2));
								startOfSubstring = i+2;
								i = i+1;
							}
						}					
					}
				}
			}
			else{
				i = i + 1;
			}
		}
		syllables.add(this.word.substring(startOfSubstring, length+1));
		return syllables;
	}
	public ArrayList<String> getSyllables(){
		return this.syllables;
	}
	private String determineType(){
		char[] chars = {'n', 's', 'a', 'e', 'i','o','u','y'};
		ArrayList<Character> reglaUno =  new ArrayList<Character>();
		for (char c : chars){
			reglaUno.add(c);
		}

		String wordType = "Null";
		char lastChar = this.word.charAt(this.word.length() - 1);

		if (reglaUno.contains(lastChar)){
			wordType ="llana";
		}
		else{
			wordType = "aguda";
		}
		return wordType;
	}

	public String getType(){
		return this.type;
	}
}
