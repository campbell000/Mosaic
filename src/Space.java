/**
 * Space on the board
 * @author rachelfraczkowski
 *
 */
public class Space {

	Action action;
	boolean occupied = false;
	Tile currentTile;
	
	protected Space(){
		
	}
	
	public String toString(){
		return action.toString();
	}
	
	public void placeTile(Tile t){
		occupied = true;
		currentTile = t;
	}
	
	public void removeTile(){
		occupied = false;
		currentTile = null;
	}
	
	protected boolean isOccupied(){
		return occupied;
	}
}
