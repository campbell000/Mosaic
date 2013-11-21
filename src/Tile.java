/**
 * Tile Class
 * Represents game pieces for Mosaic game. Contains value int and
 * a letter for the tile itself.
 * @author rachelfraczkowski
 *
 */
public class Tile {
	
	//Two attributes of the Tile
	private int value = 0;
	private char letter;
	
	
	//Assigns values at controller.
	/**
	 * Constructor of Tile object
	 * @param v, the int value of the tile
	 * @param l, the char letter of the tile
	 */
	protected Tile(int v, char l){
		
		value = v;
		letter = l;
	}

	//Accessors
	/**
	 * Returns the value of the tile
	 * @return an int representing the value of the tile
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Returns the letter of the tile
	 * @return a char representing the letter of the tile
	 */
	public char getLetter(){
		return letter;
	}
	
	//ToString
	/**
	 * ToString method for Tile
	 */
	public String toString(){
		
		return Character.toString(letter);
	}
}
