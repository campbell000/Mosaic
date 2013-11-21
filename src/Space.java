/**
 * Space on the board
 * @author rachelfraczkowski
 *
 */
public class Space {

	private boolean occupied = false;
	private Tile currentTile;
	private boolean alreadyUsed = false;
	
	/**
	 * ToString method
	 */
	public String toString(){
		return " ";
	}
	
	//Tile stuff
	/**
	 * Places Tile on Space
	 * @param t, a tile to be placed on space
	 */
	public void placeTile(Tile t){
		//System.out.println(t.toString() + " was placed");
		occupied = true;
		currentTile = t;
	}
	
	/**
	 * Removes tile on space
	 */
	public void removeTile(){
		occupied = false;
		currentTile = null;
	}
	
	/**
	 * Accessor for the tile on the space
	 * @return currentTile, the tile on the space
	 */
	public Tile getTile(){
		return currentTile;
	}
	//Returns whether it is occupied
	/**
	 * Returns whether the space is occupied by a tile
	 * @return occupied, a boolean representing whether there is a tile or not
	 */
	protected boolean isOccupied(){
		return occupied;
	}
	
	//Acessors and setters for used
	/**
	 * Accessor for the space's action has been used/its first placement
	 * @return alreadyUsed, a boolean representing the above statement
	 */
	protected boolean getUsed(){
		return alreadyUsed;
	}
	
	/**
	 * Setter for alreadyUsed
	 * This is for the initial calculation of a tile, so that
	 * 	another player does not get points for the tile.
	 */
	public void setUsed(){
		alreadyUsed = true;
	}
}
