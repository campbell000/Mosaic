import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * This is generic code for a class
 * 
 * @author Armando Benavidez
 * @version 1.0
 */

public class GameBoardController {

	private final GameBoardInstance gameBoard;
	private final User user;
	private GameSystem game;

	private final ArrayList<Tile> currentHand;

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
	public GameBoardController(GameBoardInstance gameBoard, User u) {
		user = u;
		game = new GameSystem();

		this.gameBoard = gameBoard;

		this.gameBoard.addDoubleListener(new DoubleListener());
		this.gameBoard.addSwapTilesListener(new SwapTilesListener());
		this.gameBoard.addPlayHandListener(new PlayHandListener());
		this.gameBoard.addForfeitListener(new ForfeitListener());
		this.gameBoard.setGameBoardTableModel();

		currentHand = game.tileSystem.drawTiles(7);
		this.gameBoard.setInitialCurrentHandTableModel(currentHand);

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
				game.doubleGameValue();
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
		public void actionPerformed(ActionEvent swapTilesAttempt) {

			int[] toChange;

			// currently just getting the index of the letter you want to swap
			toChange = gameBoard.getEnabledHandTiles();

			/**
			 * login.addActionListener(new ActionListener(){ public void
			 * actionPerformed(ActionEvent actionEvent) { String username =
			 * usernameField.getText(); String pass = password.getText(); try {
			 * login(username, pass); } catch (Exception e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } } });
			 **/

			currentHand.set(toChange[0], game.tileSystem.drawTiles(1).get(0));

			gameBoard.setCurrentHandTableModel(currentHand);

			// Format is tiles all caps no spaces
			// Ex. B, F, G = "BFG"
			// game.swapTiles(hand);
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
			// Placing Word in the game system
			// protected int placeWord(String word, int startR, int startC, int
			// endC, int endR)
			// If a word is valid, it returns the score of the word
			// If not in dictionary, is -1
			// game.placeWord(word, startR, startC, endC, endR)

			int userSelection;
			String currentWord;

			currentWord = gameBoard.getCurrentWord();

			if (game.placeWord(currentWord, 0, 2, 0, 2) >= 0) {
				gameBoard.createBettingPopUp();
			} else {

				JOptionPane.showMessageDialog(null, "That is not a Word!");

			}

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
			int userSelection;

			userSelection = JOptionPane.showConfirmDialog(null,
					"You automatically lose this game if you forfeit!",
					"Are you sure you want to Forfiet?",
					JOptionPane.YES_NO_OPTION);

			// ALEX WAS HERE
			// when ok is selected, close all windows, and open a game window
			if (userSelection == 0) {
				// HomeScreenControllers homeScreen = new
				// HomeScreenControllers(new Home_Screen());
				Home_Screen homescreen = new Home_Screen(user);
				gameBoard.dispose();
				game.tearDown();
				game = null;

			}
		}
	}

}
