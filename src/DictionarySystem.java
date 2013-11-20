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
		
		try {
			Scanner dScan = new Scanner(new File("enable1.txt"), "UTF-8");
			while(dScan.hasNext()){
				dictionary.add(dScan.next().toUpperCase());
			}
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected boolean isAWord(String word){
		System.out.println(dictionary.contains(word));
		return dictionary.contains(word);
	}
}
