/**
 * Dictionary object determines whether or not given tiles = word
 * @author rachelfraczkowski
 *
 */
import java.util.*;
import java.io.*;

public class DictionarySystem {

	protected DictionarySystem(){
		
		try {
			Scanner dScan = new Scanner(new File("enable1.txt"), "UTF-8");
			while(dScan.hasNext()){
			System.out.println(dScan.next());}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
