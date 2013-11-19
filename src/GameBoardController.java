import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * This is generic code for a class
 * 
 * @author Armando Benavidez
 * @version 1.0
 */

public class GameBoardController {

	private final GameBoardInstance gameBoard;

	/**
	 * description sentence <code></code>
	 * 
	 * <p>
	 * description paragraph
	 * </p>
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public GameBoardController(GameBoardInstance gameBoard) {
		this.gameBoard = gameBoard;

		this.gameBoard.addDoubleListener(new DoubleListener());
		this.gameBoard.addSwapTilesListener(new SwapTilesListener());
		this.gameBoard.addPlayHandListener(new PlayHandListener());
		this.gameBoard.addForfeitListener(new ForfeitListener());

	}

	/**
	 * Inner class supporting the functionalities of the Double button found on
	 * the Mosaic game board.
	 * 
	 * This class contains the functionality of the event when a user wishes to
	 * double the value of a game. It sends a acceptance popup to the opponent
	 * and the user. If both agree on the doubling the game value is doubled.
	 * This method doubles the game value regardless if it is has already been
	 * double.
	 * 
	 * @author Armando Benavidez
	 * @version 1.0
	 */
	class DoubleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loginAttempt) {
			int userSelection;

			userSelection = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to double the value of the Game",
					"Double the game?", JOptionPane.YES_NO_OPTION);

			// ALEX WAS HERE
			// when ok is selected, close all windows, and open a game window
			if (userSelection == 0) {
				gameBoard.setDoubledText();
			}
		}
	}

	/**
	 * Inner class supporting the functionalities of the Swap Tiles button found
	 * on the Mosaic game board.
	 * 
	 * This class contains the functionality of the event when a user wishes to
	 * get a new set of seven (7) tiles on their current hand. This is only
	 * allowed once per turn.
	 * 
	 * @author Armando Benavidez
	 * @version 1.0
	 */
	class SwapTilesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loginAttempt) {
			// TODO Auto-generated method stub
		}
	}

	/**
	 * Inner class supporting the functionalities of the Play button found on
	 * the Mosaic game board.
	 * 
	 * This class contains the functionality of the event when a user wishes to
	 * play the tiles they have set on the board. This method gives the user a
	 * popup to enter the amount they wish to bid ( a bid of zero (0) is
	 * allowed).
	 * 
	 * @author Armando Benavidez
	 * @version 1.0
	 */
	class PlayHandListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loginAttempt) {
			gameBoard.createBettingPopUp();
		}
	}

	/**
	 * Inner class supporting the functionalities of the Forfeit button found on
	 * the Mosaic game board.
	 * 
	 * This class contains the functionality of the event when a user wishes to
	 * end a Mosaic game session prematurely. The opponent is given the game
	 * value and victory. The user thus loses, and the value is refelected on
	 * their account. Takes user back to the Home screen.
	 * 
	 * @author Armando Benavidez
	 * @version 1.0
	 */
	class ForfeitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loginAttempt) {
			// TODO Auto-generated method stub
		}
	}

}
