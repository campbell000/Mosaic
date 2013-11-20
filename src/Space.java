/**
 * Space on the board
 * @author rachelfraczkowski
 *
 */
public class Space {

	private boolean occupied = false;
	private Tile currentTile;
	private boolean alreadyUsed = false;
	
	protected Space(){
		
	}
	
	public String toString(){
		return " ";
	}
	
	//Tile stuff
	public void placeTile(Tile t){
		//System.out.println(t.toString() + " was placed");
		occupied = true;
		currentTile = t;
	}
	
	public void removeTile(){
		occupied = false;
		currentTile = null;
	}
	
	public Tile getTile(){
		return currentTile;
	}
	//Returns whether it is occupied
	protected boolean isOccupied(){
		return occupied;
	}
	
	//Acessors and setters for used
	protected boolean getUsed(){
		return alreadyUsed;
	}
	public void setUsed(){
		alreadyUsed = true;
	}
}
