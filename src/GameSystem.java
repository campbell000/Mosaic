import java.util.ArrayList;

/**
 * Centeralized area for game logic.Communicates with gamecontroller.
 * @author rachelfraczkowski
 *
 */
public class GameSystem {
	
	Board gameBoard;
	DictionarySystem dictionary;
	DoublingSystem doubleSystem;
	ScoringSystem scoring;
	TileSystem tileSystem;
	int gameValue;
	
	
	//Initializing Game System
	protected GameSystem(){
		
		gameBoard = new Board();
		scoring = new ScoringSystem();
		doubleSystem = new DoublingSystem();
		dictionary = new DictionarySystem();
		tileSystem = new TileSystem();
		gameValue = 1;
		
	}

	//Swaping Tiles
	protected String[] swapTiles(String hand){
		
		String[] newHand = new String[hand.length()];
		
		ArrayList<Tile> newTiles = tileSystem.swapTiles(tileSystem.getTiles(hand));
		for(int i = 0; i < newTiles.size(); i++){
			newHand[i] = newTiles.get(i).toString();
		}
		
		return newHand;
	}
	//Doubling GameValue of System
	protected int doubleGameValue(){
		
		gameValue = doubleSystem.doubleValue(gameValue);
		return gameValue;
		
	}
	
	//Return game value
	protected int getValue(){
		return gameValue;
	}
	
	protected int placeWord(String word, int startR, int startC, int endC, int endR){
		//Need string of words trying to be placed, starting indicies and ending indicies
		if(dictionary.isAWord(word)){
			ArrayList<Tile> wordTiles = tileSystem.getTiles(word);
			//System.out.println("made it past wordTiles");
			gameBoard.placeTiles(wordTiles, startR, startC, endR, endC);
			return getScore(gameBoard.getSpaces(startC, startR, endR, endC));
		}
		
		return -1;
	}
	
	protected int getScore(ArrayList<Space> spaces){
		
		return scoring.calculateScore(spaces);
	}
	
	/**
	 * Tear down method
	 */
	protected void tearDown(){
		gameValue = 0;
		gameBoard = null;
		scoring = null;
		doubleSystem = null;
		dictionary = null;
		tileSystem = null;
	}
}
