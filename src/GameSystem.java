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
	int gameValue;
	
	
	//Initializing Game System
	protected GameSystem(){
		
		gameBoard = new Board();
		scoring = new ScoringSystem();
		doubleSystem = new DoublingSystem();
		gameValue = 1;
		
	}

	//Doubling GameValue of System
	protected int doubleGameValue(){
		
		gameValue = doubleSystem.doubleValue(gameValue);
		return gameValue;
		
	}
}
