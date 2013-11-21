/**
 * Dictionary object determines whether or not given tiles = word
 * @author rachelfraczkowski
 *
 */
import java.util.*;
import java.io.*;

public class DictionarySystem {

	HashSet<String> dictionary = new HashSet<String>();
	protected DictionarySystem(){
		
		//Try reading in the file to make up the dictionary
		try {
			Scanner dScan = new Scanner(new File("enable1.txt"), "UTF-8");
			while(dScan.hasNext()){
				dictionary.add(dScan.next().toUpperCase());
			}
		
		} 
		//Throw a file not found exception
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Determines whether the letters trying to be placed
	 * is actually a word
	 * @param word, a string of the letters trying to be placed
	 * @return boolean true if a word, false if not
	 */
	protected boolean isAWord(String word){
		System.out.println(dictionary.contains(word));
		return dictionary.contains(word);
	}
}
