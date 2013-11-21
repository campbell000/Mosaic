import java.util.ArrayList;

/**
 * Centeralized area for game logic.Communicates with gamecontroller.
 * This class also contains many systems that make up the Mosaic game.
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
	/**
	 * Constructor for the game system
	 */
	protected GameSystem(){
		
		gameBoard = new Board();
		scoring = new ScoringSystem();
		doubleSystem = new DoublingSystem();
		dictionary = new DictionarySystem();
		tileSystem = new TileSystem();
		gameValue = 1;
		
	}

	//Swaping Tiles
	/**
	 * Allows player to swap Tiles from their hand
	 * @param hand, a string of the tiles wanting to swap 
	 * (Ex. B, D, F is represented by the string "BDF")
	 * @return an array of strings representing the new tiles.
	 */
	protected String[] swapTiles(String hand){
		
		String[] newHand = new String[hand.length()];
		
		ArrayList<Tile> newTiles = tileSystem.swapTiles(tileSystem.getTiles(hand));
		for(int i = 0; i < newTiles.size(); i++){
			newHand[i] = newTiles.get(i).toString();
		}
		
		return newHand;
	}
	//Doubling GameValue of System
	/**
	 * Allows player to double the value of their game
	 * @return gameValue, an int representing the doubled value of the game
	 */
	protected int doubleGameValue(){
		
		gameValue = doubleSystem.doubleValue(gameValue);
		return gameValue;
		
	}
	
	//Return game value
	/**
	 * Allows player to access the value of their game
	 * @return gameValue, the value of their game
	 */
	protected int getValue(){
		return gameValue;
	}
	
	/**
	 * Allows player to place a word on the gameboard.
	 * @param word, a string of the word created by their tiles
	 * @param startR, starting row of the index where they would like to place the tiles
	 * @param startC, starting column of the index where they would like to place the tiles
	 * @param endC, ending column of the index where they would like their word to end
	 * @param endR, ending row of the index where they would like their word to end
	 * @return an int representing the score of the word placed, or -1 if not a word
	 */
	protected int placeWord(String word, int startR, int startC, int endC, int endR){
		//Need string of words trying to be placed, starting indicies and ending indicies
		if(dictionary.isAWord(word)){
			ArrayList<Tile> wordTiles = tileSystem.getTiles(word);
			//System.out.println("made it past wordTiles");
			gameBoard.placeTiles(wordTiles, startR, startC, endR, endC);
			
			return getScore(gameBoard.getSpaces(startR, startC, endR, endC));
		}
		
		return -1;
	}
	
	/**
	 * Gets the score of the an array of spaces and the tiles they contain
	 * @param spaces, an array of type Space, 
	 * 		  usually the spaces where tiles have just been placed.
	 * @return an int representing the score of the game.
	 */
	protected int getScore(ArrayList<Space> spaces){
		
		return scoring.calculateScore(spaces);
	}
	
	
	/**
	 * Tear down method, which empties out all systems within the
	 * gameSystem. 
	 */
	protected void tearDown(){
		gameValue = 0;
		gameBoard = null;
		scoring = null;
		doubleSystem = null;
		dictionary = null;
		tileSystem = null;
	}

	/**
	 * Accessor the gameBoard as an object
	 * @return Object, the gameboard
	 */
	public Object getGameBoard() {
		return this.gameBoard;
	}
	
	/**
	 * Returns board of the game
	 * @return gameBoard, an Array of Spaces
	 */
	protected Space[][] getBoard(){
		return gameBoard.getBoard();
	}
	
}
