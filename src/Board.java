/**
 * Board of the game
 * @author rachelfraczkowski
 *
 */
import java.util.*;

public class Board {

	Space [][] gameBoard;
	protected Board(){
		
		gameBoard = new Space [15][15];
		this.placeSpaces();
		
		
	}
	/**
	 * Places the spaces on the board object
	 * @param board
	 * @param tW
	 * @param dW
	 * @param tL
	 * @param dL
	 */
	private void placeSpaces(){
		
		//Placing all normal spaces first
		for (int l = 0; l < gameBoard.length; l++){
			for(int w = 0; w < gameBoard.length; w++){
				gameBoard[l][w] = new NormalSpace();
			}
		}
		
		//Place triple Word spaces
		gameBoard[0][0] = new SpecialSpace("3W");
		gameBoard[0][7] = new SpecialSpace("3W");
		gameBoard[0][14] = new SpecialSpace("3W");
				
		gameBoard[7][0] = new SpecialSpace("3W");
		gameBoard[7][14] = new SpecialSpace("3W");
				
		gameBoard[14][0] = new SpecialSpace("3W");
		gameBoard[14][7] = new SpecialSpace("3W");
		gameBoard[14][14] = new SpecialSpace("3W");
		
		//Place Double Word Spaces
		gameBoard[1][1] = new SpecialSpace("2W");
		gameBoard[2][2] = new SpecialSpace("2W");
		gameBoard[3][3] = new SpecialSpace("2W");
		gameBoard[4][4] = new SpecialSpace("2W");
		
		gameBoard[4][10] = new SpecialSpace("2W");
		gameBoard[3][11] = new SpecialSpace("2W");
		gameBoard[2][12] = new SpecialSpace("2W");
		gameBoard[1][13] = new SpecialSpace("2W");
		
		gameBoard[13][1] = new SpecialSpace("2W");
		gameBoard[12][2] = new SpecialSpace("2W");
		gameBoard[11][3] = new SpecialSpace("2W");
		gameBoard[10][4] = new SpecialSpace("2W");
		
		gameBoard[13][13] = new SpecialSpace("2W");
		gameBoard[12][12] = new SpecialSpace("2W");
		gameBoard[11][11] = new SpecialSpace("2W");
		gameBoard[10][10] = new SpecialSpace("2W");
		
		//Triple Letter
		gameBoard[1][5] = new SpecialSpace("3L");
		gameBoard[1][9] = new SpecialSpace("3L");
		
		gameBoard[5][1] = new SpecialSpace("3L");
		gameBoard[5][5] = new SpecialSpace("3L");
		gameBoard[5][9] = new SpecialSpace("3L");
		gameBoard[5][14] = new SpecialSpace("3L");
		
		gameBoard[9][1] = new SpecialSpace("3L");
		gameBoard[9][5] = new SpecialSpace("3L");
		gameBoard[9][9] = new SpecialSpace("3L");
		gameBoard[9][14] = new SpecialSpace("3L");
		
		gameBoard[14][5] = new SpecialSpace("3L");
		gameBoard[14][9] = new SpecialSpace("3L");
		
		//Double Letter
		gameBoard[0][3] = new SpecialSpace("2L");
		gameBoard[0][11] = new SpecialSpace("2L");
		
		gameBoard[2][6] = new SpecialSpace("2L");
		gameBoard[2][8] = new SpecialSpace("2L");
		
		gameBoard[3][0] = new SpecialSpace("2L");
		gameBoard[3][7] = new SpecialSpace("2L");
		gameBoard[3][14] = new SpecialSpace("2L");
		
		gameBoard[6][2] = new SpecialSpace("2L");
		gameBoard[6][6] = new SpecialSpace("2L");
		gameBoard[6][8] = new SpecialSpace("2L");
		gameBoard[6][12] = new SpecialSpace("2L");
		
		gameBoard[7][3] = new SpecialSpace("2L");
		gameBoard[7][11] = new SpecialSpace("2L");
		
		gameBoard[8][2] = new SpecialSpace("2L");
		gameBoard[8][6] = new SpecialSpace("2L");
		gameBoard[8][8] = new SpecialSpace("2L");
		gameBoard[8][12] = new SpecialSpace("2L");
		
		gameBoard[11][0] = new SpecialSpace("2L");
		gameBoard[11][7] = new SpecialSpace("2L");
		gameBoard[11][14] = new SpecialSpace("2L");
		
		gameBoard[12][6] = new SpecialSpace("2L");
		gameBoard[12][8] = new SpecialSpace("2L");
		
		gameBoard[14][3] = new SpecialSpace("2L");
		gameBoard[14][11] = new SpecialSpace("2L");
		
		/************************************************/
		
		/*//Printing all spaces
		for (int l = 0; l < board.length; l++){
			for(int w = 0; w < board.length; w++){
				System.out.println(board[l][w]);
			}
		}*/
				
		
	}
	/**
	 * Returns space at particular index
	 * @param c
	 * @param r
	 * @return
	 */
	protected Space getSpace(int c, int r){
		return gameBoard[c][r];
	}
	
	/**
	 * Returns an arraylist of spaces for system to use starting with one coordinate, 
	 * ending with another 
	 * 
	 * @param startC
	 * @param startR
	 * @param endC
	 * @param endR
	 * @return
	 */
	protected ArrayList<Space> getSpaces(int startC, int startR, int endC, int endR){
		
		//System.out.println("In getSpaces method!");
		ArrayList<Space> spaces = new ArrayList<Space>();
		
		//System.out.println(gameBoard[0][0]);
		
		//Vertical Word placement
		if(startC == endC){
			for( int j = startR ; j <= endR; j++){
					
				spaces.add(gameBoard[startC][j]);		
					
			}
		}
		
		//Horizontal Word placement
		else if(startR == endR){
			for( int i = startC ; i <= endC; i++){
	
				spaces.add(gameBoard[i][startR]);		
					
			}
		}
		
		//Else == wrong
		else{
			System.out.println("Error");
		}
		System.out.println(spaces.size());
		return spaces;
	}
	
	protected void placeTiles(ArrayList<Tile> tiles, int startC, int startR, int endC, int endR){
		//System.out.println("made it to placeTiles");
		Space tileSpace = new Space();
		//Vertical Word Placement
		if(startC == endC){
			int row = startR;
			while(row<=endR){
				for (int i = 0; i < tiles.size(); i++){
					//System.out.println("reached game board");
					tileSpace = gameBoard[startC][row];
					tileSpace.placeTile(tiles.get(i));
					row++;
				}
			}
		}
		
		//Horizontal Word Placement
		if(startR == endR){
			int col = startC;
			while(col<=endC){
				for (int i = 0; i < tiles.size(); i++){
					//System.out.println("reached game board");
					tileSpace = gameBoard[col][startR];
					tileSpace.placeTile(tiles.get(i));
					col++;
				}
			}
		}
	}
}
