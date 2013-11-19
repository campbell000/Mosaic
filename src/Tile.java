/**
 * Tile Class
 * Represents game pieces for Mosaic game. Contains value int and
 * a letter for the tile itself.
 * @author rachelfraczkowski
 *
 */
public class Tile {
	
	//Two attributes of the Tile
	private int value;
	private char letter;
	
	
	//Assigns values at controller.
	protected Tile(int v, char l){
		
		value = v;
		letter = l;
	}

	//Accessors
	public int getValue(){
		return value;
	}
	
	public char getLetter(){
		return letter;
	}
	
	//ToString
	public String toString(){
		
		return Character.toString(letter);
	}
}
