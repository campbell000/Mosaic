import java.util.*;


/**
 * Contains the Tiles for the System
 * @author rachelfraczkowski
 *
 */
public class TileSystem {
	
	ArrayList<Tile> tileBag = new ArrayList<Tile>();
	Map<Character, Integer > alphabetValue = new HashMap<Character, Integer>();
	
	public TileSystem(){
		
		this.initAlphabet();
		//TemporaryTile used for creation
		Tile tempTile;
		
		
		//Letter A
		for(int i=0; i < 9; i++){
			tempTile = new Tile(alphabetValue.get('A'), 'A');
			tileBag.add(tempTile);
		}
		
		//Letter B
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('B'), 'B');
			tileBag.add(tempTile);
		}
		
		//Letter C
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('C'), 'C');
			tileBag.add(tempTile);
		}
		
		//Letter D
		for(int i = 0; i <4; i++){
			tempTile = new Tile(alphabetValue.get('D'), 'D');
			tileBag.add(tempTile);
		}
		
		//Letter E
		for(int i = 0; i <12; i++){
			tempTile = new Tile(alphabetValue.get('E'), 'E');
			tileBag.add(tempTile);
		}
		
		//Letter F
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('F'), 'F');
			tileBag.add(tempTile);
		}
		
		//Letter G
		for(int i = 0; i <3; i++){
			tempTile = new Tile(alphabetValue.get('G'), 'G');
			tileBag.add(tempTile);
		}
		
		//Letter H
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('H'), 'H');
			tileBag.add(tempTile);
		}
		
		//Letter I
		for(int i = 0; i <9; i++){
			tempTile = new Tile(alphabetValue.get('I'), 'I');
			tileBag.add(tempTile);
		}
		
		//Letter J
		for(int i = 0; i <1; i++){
			tempTile = new Tile(alphabetValue.get('J'), 'J');
			tileBag.add(tempTile);
		}
		
		//Letter K
		for(int i = 0; i <1; i++){
			tempTile = new Tile(alphabetValue.get('K'), 'K');
			tileBag.add(tempTile);
		}
		
		//Letter L
		for(int i = 0; i <4; i++){
			tempTile = new Tile(alphabetValue.get('L'), 'L');
			tileBag.add(tempTile);
		}
		
		//Letter M
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('M'), 'M');
			tileBag.add(tempTile);
		}
		
		//Letter N
		for(int i = 0; i <6; i++){
			tempTile = new Tile(alphabetValue.get('N'), 'N');
			tileBag.add(tempTile);
		}
		
		//Letter O
		for(int i = 0; i <8; i++){
			tempTile = new Tile(alphabetValue.get('O'), 'O');
			tileBag.add(tempTile);
		}
		
		//Letter P
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('P'), 'P');
			tileBag.add(tempTile);
		}
		
		//Letter Q
		for(int i = 0; i <1; i++){
			tempTile = new Tile(alphabetValue.get('Q'), 'Q');
			tileBag.add(tempTile);
		}
		
		//Letter R
		for(int i = 0; i <6; i++){
			tempTile = new Tile(alphabetValue.get('R'), 'R');
			tileBag.add(tempTile);
		}
		
		//Letter S
		for(int i = 0; i <4; i++){
			tempTile = new Tile(alphabetValue.get('S'), 'S');
			tileBag.add(tempTile);
		}
		
		//Letter T
		for(int i = 0; i <6; i++){
			tempTile = new Tile(alphabetValue.get('T'), 'T');
			tileBag.add(tempTile);
		}
		
		//Letter U
		for(int i = 0; i <4; i++){
			tempTile = new Tile(alphabetValue.get('U'), 'U');
			tileBag.add(tempTile);
		}
		
		//Letter V
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('V'), 'V');
			tileBag.add(tempTile);
		}
		
		//Letter W
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('W'), 'W');
			tileBag.add(tempTile);
		}
		
		//Letter X
		for(int i = 0; i <1; i++){
			tempTile = new Tile(alphabetValue.get('X'), 'X');
			tileBag.add(tempTile);
		}
		
		//Letter Y
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get('Y'), 'Y');
			tileBag.add(tempTile);
		}
		
		//Letter Z
		for(int i = 0; i <1; i++){
			tempTile = new Tile(alphabetValue.get('Z'), 'Z');
			tileBag.add(tempTile);
		}
		
		//Blank Tiles
		for(int i = 0; i <2; i++){
			tempTile = new Tile(alphabetValue.get(' '), ' ');
			tileBag.add(tempTile);
		}
		
		//System.out.println(tileBag.toString());
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
	
	private void initAlphabet (){
		
		//alphabetValue
		alphabetValue.put('A', 1);
		alphabetValue.put('B', 2);
		alphabetValue.put('C', 3);
		alphabetValue.put('D', 2);
		alphabetValue.put('E', 1);
		alphabetValue.put('F', 4);
		alphabetValue.put('G', 2);
		alphabetValue.put('H', 4);
		alphabetValue.put('I', 1);
		alphabetValue.put('J', 8);
		alphabetValue.put('K', 5);
		alphabetValue.put('L', 1);
		alphabetValue.put('M', 3);
		alphabetValue.put('N', 1);
		alphabetValue.put('O', 1);
		alphabetValue.put('P', 3);
		alphabetValue.put('Q', 10);
		alphabetValue.put('R', 1);
		alphabetValue.put('S', 1);
		alphabetValue.put('T', 1);
		alphabetValue.put('U', 1);
		alphabetValue.put('V', 4);
		alphabetValue.put('W', 4);
		alphabetValue.put('X', 8);
		alphabetValue.put('Y', 4);
		alphabetValue.put('Z', 10);
		alphabetValue.put(' ', 0);
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
			drawIndex = rand.nextInt(tileBag.size());
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
	
	public ArrayList<Tile> swapTiles(ArrayList<Tile> oldTiles){
		//Random Generator mimics randomness of drawing from bag
		//Produces Random Index for arraylist
		Random rand = new Random();
		int drawIndex = rand.nextInt(tileBag.size());
				
		//ArrayList of NewTiles
		ArrayList<Tile> newTiles = new ArrayList<Tile>();
				
		for(int i = 0; i < oldTiles.size(); i++){
			//Updates the bag now that tile is removed
			Tile drawn = tileBag.get(drawIndex);
			tileBag.remove(drawIndex);
			newTiles.add(drawn);
			drawIndex = rand.nextInt(tileBag.size());
		}	
		
		for(int j = 0; j <oldTiles.size(); j++)
				tileBag.add(oldTiles.get(j));
		//returns list of drawn tiles
		return newTiles;
	}
	
	/**
	 * Translates string word into tiles to be placed on board
	 * @param word
	 * @return
	 */
	protected ArrayList<Tile> getTiles(String word){
		ArrayList<Tile> wordTiles = new ArrayList<Tile>();
		
		for(int i = 0; i < word.length(); i++){
			char letter = word.charAt(i);
			Tile temp = new Tile(alphabetValue.get(letter), letter);
			wordTiles.add(temp);
		}
		
		return wordTiles;
	}
}
