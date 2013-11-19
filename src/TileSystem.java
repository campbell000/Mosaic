import java.util.*;


/**
 * Contains the Tiles for the System
 * @author rachelfraczkowski
 *
 */
public class TileSystem {
	
	ArrayList<Tile> tileBag = new ArrayList<Tile>();
	
	public TileSystem(){
		
		//TemporaryTile used for creation
		Tile tempTile;
		
		
		//Letter A
		for(int i=0; i < 9; i++){
			tempTile = new Tile(1, 'A');
			tileBag.add(tempTile);
		}
		
		//Letter B
		for(int i = 0; i <2; i++){
			tempTile = new Tile(2, 'B');
			tileBag.add(tempTile);
		}
		
		//Letter C
		for(int i = 0; i <2; i++){
			tempTile = new Tile(3, 'C');
			tileBag.add(tempTile);
		}
		
		//Letter D
		for(int i = 0; i <4; i++){
			tempTile = new Tile(2, 'D');
			tileBag.add(tempTile);
		}
		
		//Letter E
		for(int i = 0; i <12; i++){
			tempTile = new Tile(1, 'E');
			tileBag.add(tempTile);
		}
		
		//Letter F
		for(int i = 0; i <2; i++){
			tempTile = new Tile(4, 'F');
			tileBag.add(tempTile);
		}
		
		//Letter G
		for(int i = 0; i <3; i++){
			tempTile = new Tile(2, 'G');
			tileBag.add(tempTile);
		}
		
		//Letter H
		for(int i = 0; i <2; i++){
			tempTile = new Tile(4, 'H');
			tileBag.add(tempTile);
		}
		
		//Letter I
		for(int i = 0; i <9; i++){
			tempTile = new Tile(1, 'I');
			tileBag.add(tempTile);
		}
		
		//Letter J
		for(int i = 0; i <1; i++){
			tempTile = new Tile(8, 'J');
			tileBag.add(tempTile);
		}
		
		//Letter K
		for(int i = 0; i <1; i++){
			tempTile = new Tile(5, 'K');
			tileBag.add(tempTile);
		}
		
		//Letter L
		for(int i = 0; i <4; i++){
			tempTile = new Tile(1, 'L');
			tileBag.add(tempTile);
		}
		
		//Letter M
		for(int i = 0; i <2; i++){
			tempTile = new Tile(3, 'M');
			tileBag.add(tempTile);
		}
		
		//Letter N
		for(int i = 0; i <6; i++){
			tempTile = new Tile(1, 'N');
			tileBag.add(tempTile);
		}
		
		//Letter O
		for(int i = 0; i <8; i++){
			tempTile = new Tile(1, 'O');
			tileBag.add(tempTile);
		}
		
		//Letter P
		for(int i = 0; i <2; i++){
			tempTile = new Tile(3, 'P');
			tileBag.add(tempTile);
		}
		
		//Letter Q
		for(int i = 0; i <1; i++){
			tempTile = new Tile(10, 'Q');
			tileBag.add(tempTile);
		}
		
		//Letter R
		for(int i = 0; i <6; i++){
			tempTile = new Tile(1, 'R');
			tileBag.add(tempTile);
		}
		
		//Letter S
		for(int i = 0; i <4; i++){
			tempTile = new Tile(1, 'S');
			tileBag.add(tempTile);
		}
		
		//Letter T
		for(int i = 0; i <6; i++){
			tempTile = new Tile(1, 'T');
			tileBag.add(tempTile);
		}
		
		//Letter U
		for(int i = 0; i <4; i++){
			tempTile = new Tile(1, 'U');
			tileBag.add(tempTile);
		}
		
		//Letter V
		for(int i = 0; i <2; i++){
			tempTile = new Tile(4, 'V');
			tileBag.add(tempTile);
		}
		
		//Letter W
		for(int i = 0; i <2; i++){
			tempTile = new Tile(4, 'W');
			tileBag.add(tempTile);
		}
		
		//Letter X
		for(int i = 0; i <1; i++){
			tempTile = new Tile(8, 'X');
			tileBag.add(tempTile);
		}
		
		//Letter Y
		for(int i = 0; i <2; i++){
			tempTile = new Tile(4, 'Y');
			tileBag.add(tempTile);
		}
		
		//Letter Z
		for(int i = 0; i <1; i++){
			tempTile = new Tile(10, 'Z');
			tileBag.add(tempTile);
		}
		
		//Blank Tiles
		for(int i = 0; i <2; i++){
			tempTile = new Tile(0, ' ');
			tileBag.add(tempTile);
		}
		
		System.out.println(tileBag.toString());
	} //Initializes TileBag
	
	/**
	 * 
	 * @return
	 */
	public Tile drawTile(){
		
		//Random Generator mimics randomness of drawing from bag
		//Produces Random Index for arraylist
		Random rand = new Random();
		int drawIndex = rand.nextInt(tileBag.size());
		
		//Updates the bag now that tile is removed
		Tile drawn = tileBag.get(drawIndex);
		tileBag.remove(drawIndex);
		
		//returns drawn tile
		return drawn;
	}
	
	public ArrayList<Tile> drawTiles(int num){
		
		//Random Generator mimics randomness of drawing from bag
		//Produces Random Index for arraylist
		Random rand = new Random();
		int drawIndex = rand.nextInt(tileBag.size());
		
		//ArrayList of NewTiles
		ArrayList<Tile> newTiles = new ArrayList<Tile>();
		
		for(int i = 0; i < num; i++){
			//Updates the bag now that tile is removed
			Tile drawn = tileBag.get(drawIndex);
			tileBag.remove(drawIndex);
			newTiles.add(drawn);
		}	
		//returns list of drawn tiles
		return newTiles;
		
	}
	
	public Tile swapTile(Tile n){
		
			// NEED TO ADD BACK INTO LIST
			//Random Generator mimics randomness of drawing from bag
			//Produces Random Index for arraylist
			Random rand = new Random();
			int drawIndex = rand.nextInt(tileBag.size());
			
			//Updates the bag now that tile is removed
			Tile drawn = tileBag.get(drawIndex);
			tileBag.remove(drawIndex);
			
			//returns drawn tile
			
			//return the drawn tile back into tilebag
			tileBag.add(n);
			
			return drawn;
	}
	
	public ArrayList<Tile> swapTiles(int num){
		//Random Generator mimics randomness of drawing from bag
		//Produces Random Index for arraylist
		Random rand = new Random();
		int drawIndex = rand.nextInt(tileBag.size());
				
		//ArrayList of NewTiles
		ArrayList<Tile> newTiles = new ArrayList<Tile>();
				
		for(int i = 0; i < num; i++){
			//Updates the bag now that tile is removed
			Tile drawn = tileBag.get(drawIndex);
			tileBag.remove(drawIndex);
			newTiles.add(drawn);
		}	
		//returns list of drawn tiles
		return newTiles;
	}

}
