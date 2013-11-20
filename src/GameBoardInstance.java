import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

/**
 * 
 * @author Armando Benavidez
 * @version .0
 */

public class GameBoardInstance extends JFrame {

	private final User user;
	JPanel panelGameBoard;
	UserNameplate theUser;
	UserNameplate theOpponent;
	JButton buttonDouble;
	private JLabel userPotentialScore;
	GameBoardComponent theGameBoard;
	CurrentHandComponent theCurrentHand;
	JButton buttonSwap;
	JPanel testPanel;

	JButton buttonPlay;

	JButton buttonForfeit;
	JButton buttonTilesLeft;
	JButton buttonLogo;

	/**
	 * generic comment
	 * 
	 * <p>
	 * <code></code>
	 * </p>
	 * 
	 * @param <code></code>
	 * @return <code></code>
	 * 
	 */
	public GameBoardInstance(User u) {
		super();
		user = u;
		setContentPane(createContent());

		setResizable(false);
		// setDropTarget(getDropTarget());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private Container createContent() {

		panelGameBoard = new JPanel();

		panelGameBoard.setBackground(new Color(214, 213, 213));
		panelGameBoard.setForeground(new Color(0, 0, 0));

		panelGameBoard.setBorder(BorderFactory
				.createEmptyBorder(10, 10, 10, 10));

		theGameBoard = new GameBoardComponent();
		theCurrentHand = new CurrentHandComponent();
		buttonSwap = new JButton();
		testPanel = new JPanel();

		theUser = new UserNameplate();
		theOpponent = new UserNameplate();
		buttonDouble = new JButton();
		buttonPlay = new JButton();

		JTextField testTextField = new JTextField();
		// testTextField.setDropTarget(getDropTarget());

		buttonForfeit = new JButton("Forfeit");
		buttonTilesLeft = new JButton();
		buttonLogo = new JButton();
		userPotentialScore = new JLabel(" Potential Word Score: 000 090");

		testPanel.setBackground(new Color(1, 1, 1));

		buttonForfeit.setFont(new java.awt.Font("Aharoni", 0, 13));

		userPotentialScore.setFont(new java.awt.Font("Aharoni", 0, 14));
		userPotentialScore.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(102, 102, 102), 1));

		/**
		 * File imageCheck = new File("src/swap-icon.jpg");
		 * if(imageCheck.exists()) System.out.println("Image file found!"); else
		 * System.out.println("Image file not found!");
		 **/

		buttonSwap.setBackground(new java.awt.Color(153, 187, 201));
		buttonSwap.setForeground(new java.awt.Color(0, 0, 0));
		buttonSwap.setIcon(new ImageIcon(getClass().getResource(
				"resources/swap-icon.jpg")));
		buttonSwap.setBorderPainted(false);

		buttonTilesLeft.setIcon(new ImageIcon(getClass().getResource(
				"resources/sack2.png")));
		buttonPlay.setIcon(new ImageIcon(getClass().getResource(
				"resources/playArrow.png")));
		buttonDouble.setIcon(new ImageIcon(getClass().getResource(
				"resources/doubleDice.png")));
		buttonLogo.setIcon(new ImageIcon(getClass().getResource(
				"resources/mosaicBanner.jpg")));

		GroupLayout layout = new GroupLayout(panelGameBoard);
		panelGameBoard.setLayout(layout);

		// Layout of the group

		layout.setAutoCreateGaps(true);
		// panelLoginLayout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout
				.createSequentialGroup()

				.addGap(40)

				.addGroup(
						layout.createParallelGroup()
								.addGap(81, 81, 81)
								.addComponent(theUser)

								.addComponent(theOpponent)

								.addGroup(
										layout.createSequentialGroup()
												.addGap(135)
												.addComponent(buttonTilesLeft,
														91, 91, 91))
								.addGroup(
										layout.createSequentialGroup()
												.addGap(80)
												.addComponent(
														userPotentialScore,
														200, 200, 200))

								.addGroup(
										layout.createSequentialGroup()
												.addGap(130)

												.addComponent(testTextField,
														40, 40, 40)
												.addComponent(buttonForfeit,
														110, 110, 110))
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(buttonLogo, 380,
														380, 380)))
				.addGap(30)
				.addGroup(
						layout.createParallelGroup()

								.addComponent(theGameBoard, 750, 750, 750)

								.addGroup(
										layout.createSequentialGroup()
												.addGap(20)
												.addComponent(theCurrentHand,
														350, 350, 350)
												.addGap(15)
												.addComponent(buttonPlay)
												.addGap(80)
												.addComponent(buttonSwap, 60,
														60, 60)
												.addGap(30)
												.addComponent(buttonDouble, 60,
														60, 60))));// setHorizontalGroup

		layout.setVerticalGroup(layout
				.createParallelGroup()
				.addGroup(
						layout.createSequentialGroup()
								.addGap(50)
								.addComponent(theUser)
								.addGap(40)
								.addComponent(theOpponent)
								.addGap(55)
								.addComponent(buttonTilesLeft, 91, 91, 91)
								.addGap(20)
								.addComponent(userPotentialScore, 30, 30, 30)
								.addGap(30)
								.addGroup(
										layout.createParallelGroup()
												.addComponent(testTextField,
														35, 35, 35)
												.addComponent(buttonForfeit,
														50, 50, 50))
								.addGap(40)
								.addGroup(
										layout.createParallelGroup()
												.addGap(20)
												.addComponent(buttonLogo, 180,
														180, 180)))

				.addGroup(
						layout.createSequentialGroup()
								.addComponent(theGameBoard, 675, 675, 675)
								.addGap(15)
								.addGroup(
										layout.createParallelGroup()
												.addGroup(
														layout.createSequentialGroup()
																.addGap(7)
																.addComponent(
																		theCurrentHand,
																		45, 45,
																		45))
												.addComponent(buttonPlay)
												.addComponent(buttonSwap, 60,
														60, 60)
												.addComponent(buttonDouble, 60,
														60, 60))));// setVerticalGroup

		GroupLayout windowlayout = new GroupLayout(getContentPane());

		getContentPane().setLayout(windowlayout);
		windowlayout
				.setHorizontalGroup(windowlayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameBoard, GroupLayout.DEFAULT_SIZE,
								784, Short.MAX_VALUE));
		windowlayout
				.setVerticalGroup(windowlayout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(panelGameBoard, GroupLayout.DEFAULT_SIZE,
								444, Short.MAX_VALUE));

		pack();
		return panelGameBoard;
	}

	private class BettingPopUp extends JFrame {

		JPanel panelBetting;
		JLabel labelBanner;
		JTextField textBetAmount;
		JButton buttonBet;
		JButton buttonCancel;

		int betValue;
		JSlider sliderBet;

		/**
		 * sliderBet.setMajorTickSpacing(10); sliderBet.setMinorTickSpacing(1);
		 * sliderBet.setPaintTicks(true); sliderBet.setPaintLabels(true);
		 * sliderBet.setBorder( BorderFactory.createEmptyBorder(0,0,10,0)); Font
		 * font = new Font("Serif", Font.ITALIC, 15);
		 * framesPerSecond.setFont(font);
		 * 
		 * sliderBet.addChangeListener(new javax.swing.event.ChangeListener() {
		 * public void stateChanged(javax.swing.event.ChangeEvent evt) {
		 * sliderBetStateChanged(evt); } });
		 **/

		public BettingPopUp() {
			setContentPane(createBettingContent());
			setResizable(false);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2,
					dim.height / 2 - this.getSize().height / 2);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}

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
		private Container createBettingContent() {
			betValue = 0;
			panelBetting = new JPanel();
			labelBanner = new JLabel();
			textBetAmount = new JTextField();
			buttonBet = new JButton("Bet");
			buttonCancel = new JButton("Cancel");

			buttonBet.setFont(new java.awt.Font("Aharoni", 0, 15));
			buttonCancel.setFont(new java.awt.Font("Aharoni", 0, 13));
			textBetAmount.setFont(new java.awt.Font("Aharoni", 0, 22));

			textBetAmount.setHorizontalAlignment(JTextField.CENTER);

			sliderBet = new JSlider(JSlider.HORIZONTAL, 0, 600, 300);

			sliderBet.setMajorTickSpacing(150);
			sliderBet.setMinorTickSpacing(150);
			// sliderBet.setPaintTicks(true);

			textBetAmount.setText(String.valueOf(sliderBet.getValue()));

			sliderBet.setPaintLabels(true);
			sliderBet.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
			// sliderBet.setFont(new Font("Serif", Font.ITALIC, 15));
			sliderBet.addChangeListener(new javax.swing.event.ChangeListener() {
				@Override
				public void stateChanged(javax.swing.event.ChangeEvent evt) {
					sliderBetStateChanged(evt);
				}
			});

			labelBanner.setIcon(new ImageIcon(getClass().getResource(
					"resources/bettingbanner.jpg")));
			labelBanner.setEnabled(false);

			buttonBet.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					buttonBetActionPerformed(evt);
				}
			});

			buttonCancel.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					dispose();
				}
			});

			GroupLayout panelBettingLayout = new GroupLayout(panelBetting);
			panelBetting.setLayout(panelBettingLayout);

			// Layout of the group

			panelBettingLayout.setAutoCreateGaps(true);
			// panelLoginLayout.setAutoCreateContainerGaps(true);

			panelBettingLayout
					.setHorizontalGroup(panelBettingLayout
							.createParallelGroup()
							.addComponent(labelBanner, 500, 500, 500)
							.addGroup(
									panelBettingLayout
											.createSequentialGroup()
											.addGap(120)
											.addComponent(textBetAmount, 250,
													250, 250))
							.addGroup(
									panelBettingLayout
											.createSequentialGroup()
											.addGap(110)
											.addComponent(sliderBet, 270, 270,
													270))

							.addGroup(
									panelBettingLayout
											.createSequentialGroup()
											.addGap(150)
											.addComponent(buttonBet, 80, 80, 80)
											.addGap(50)
											.addComponent(buttonCancel, 80, 80,
													80)).addGap(0));// setHorizontalGroup

			panelBettingLayout.setVerticalGroup(panelBettingLayout
					.createSequentialGroup()
					.addComponent(labelBanner, 120, 120, 120)
					.addGap(20)
					.addComponent(textBetAmount, 50, 50, 50)
					.addGap(0)
					.addGap(20)
					.addComponent(sliderBet, 50, 50, 50)
					.addGap(30)
					.addGroup(
							panelBettingLayout.createParallelGroup()
									.addComponent(buttonBet, 30, 30, 30)
									.addComponent(buttonCancel, 30, 30, 30))
					.addGap(20)

			);// setVerticalGroup

			GroupLayout windowlayout = new GroupLayout(getContentPane());

			getContentPane().setLayout(windowlayout);
			windowlayout.setHorizontalGroup(windowlayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addComponent(
					panelBetting, GroupLayout.DEFAULT_SIZE, 450,
					Short.MAX_VALUE));
			windowlayout.setVerticalGroup(windowlayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addComponent(
					panelBetting, GroupLayout.DEFAULT_SIZE, 220,
					Short.MAX_VALUE));

			pack();
			return panelBetting;
		}

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
		protected void sliderBetStateChanged(ChangeEvent evt) {
			JSlider source = (JSlider) evt.getSource();
			if (!source.getValueIsAdjusting()) {
				int betAmount = source.getValue();
				textBetAmount.setText(String.valueOf(betAmount));
			}

		}

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
		protected void buttonAddActionPerformed(ActionEvent evt) {
			betValue += 5;
			textBetAmount.setText(" " + betValue);

		}

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
		protected void buttonBetActionPerformed(ActionEvent evt) {
			GameBoardWinPopUp winPanel = new GameBoardWinPopUp();
			dispose();
		}
	}

	private class GameBoardWinPopUp extends JFrame {

		UserNameplate theUser;
		UserNameplate theOpponent;
		JPanel winingPanel;

		JLabel labelWinner;
		JLabel labelLoser;
		JPanel panelStats;

		JButton buttonOk = new JButton();

		public GameBoardWinPopUp() {
			setContentPane(createWinningContent());
			pack();
			setResizable(false);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width / 2 - this.getSize().width / 2,
					dim.height / 2 - this.getSize().height / 2);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}

		/**
		 * The class <code>createWinningContent</code> adds all the components
		 * to the <code>GameBoardWinPopUp</code> <code></code>
		 * 
		 * <p>
		 * Creates two instances of UserNamePlates, one for the user and another
		 * for the opponent. A panel is also created for the new user
		 * statistics. *
		 * </p>
		 * 
		 * @return Container Returns a <code>JPanel</code>
		 */
		private Container createWinningContent() {

			theUser = new UserNameplate();
			theOpponent = new UserNameplate();
			winingPanel = new JPanel();
			labelWinner = new JLabel();
			labelLoser = new JLabel();
			panelStats = new StatPanel();
			buttonOk = new JButton("OK");

			// 360, 90

			buttonOk.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					dispose();
				}
			});

			labelWinner.setIcon(new ImageIcon(getClass().getResource(
					"resources/winnerBanner.jpg")));

			labelLoser.setIcon(new ImageIcon(getClass().getResource(
					"resources/loserBanner.jpg")));

			GroupLayout panelGameResultLayout = new GroupLayout(winingPanel);
			winingPanel.setLayout(panelGameResultLayout);

			// Layout of the group
			panelGameResultLayout.setAutoCreateGaps(true);

			panelGameResultLayout.setHorizontalGroup(panelGameResultLayout
					.createParallelGroup()

					.addGroup(
							panelGameResultLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(labelWinner, 360, 360, 360)
									.addComponent(labelLoser))
					.addGroup(
							panelGameResultLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(theUser, 360, 360, 360)
									.addComponent(theOpponent, 360, 360, 360))
					.addGroup(
							panelGameResultLayout.createSequentialGroup()
									.addGap(18).addComponent(panelStats))
					.addGroup(
							panelGameResultLayout.createSequentialGroup()
									.addGap(350)
									.addComponent(buttonOk, 60, 60, 60))
					.addGap(0));// setHorizontalGroup

			panelGameResultLayout.setVerticalGroup(panelGameResultLayout
					.createSequentialGroup()
					.addGap(20)
					.addGroup(
							panelGameResultLayout.createParallelGroup()
									.addComponent(labelWinner, 50, 50, 50)
									.addComponent(labelLoser, 50, 50, 50))
					.addGroup(
							panelGameResultLayout.createParallelGroup()
									.addComponent(theUser, 90, 90, 90)
									.addComponent(theOpponent, 90, 90, 90))
					.addGroup(
							panelGameResultLayout.createParallelGroup()
									.addComponent(panelStats))
					.addGap(20)
					.addGroup(
							panelGameResultLayout.createParallelGroup()
									.addComponent(buttonOk, 40, 40, 40))
					.addGap(20)

			);// setVerticalGroup

			GroupLayout windowlayout = new GroupLayout(getContentPane());

			getContentPane().setLayout(windowlayout);
			windowlayout.setHorizontalGroup(windowlayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(winingPanel, GroupLayout.DEFAULT_SIZE, 650,
							Short.MAX_VALUE));
			windowlayout.setVerticalGroup(windowlayout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(winingPanel, GroupLayout.DEFAULT_SIZE, 220,
							Short.MAX_VALUE));

			return winingPanel;
		}

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
		public class StatPanel extends JPanel {

			public StatPanel() {

				// Create smaller panel for new statistics of a user

				JLabel winCountLabel = new JLabel("WINS");
				JLabel loseCountLabel = new JLabel("LOSE");
				JLabel losePercentageLabel = new JLabel("LOSE %");
				JLabel winCountValue = new JLabel("1");
				JLabel loseCountValue = new JLabel("2");
				JLabel winPercentageValue = new JLabel("33%");

				winCountLabel.setFont(new Font("Aharoni", Font.BOLD, 22));
				loseCountLabel.setFont(new Font("Aharoni", Font.BOLD, 22));
				losePercentageLabel.setFont(new Font("Aharoni", Font.BOLD, 22));
				winCountValue.setFont(new Font("Aharoni", 0, 22));
				loseCountValue.setFont(new Font("Aharoni", 0, 22));
				winPercentageValue.setFont(new Font("Aharoni", 0, 22));
				winCountLabel.setBackground(new Color(51, 51, 51));

				setBorder(javax.swing.BorderFactory.createLineBorder(
						new java.awt.Color(51, 51, 51), 2));

				GroupLayout panelStatsLayout = new GroupLayout(this);
				setLayout(panelStatsLayout);
				setBackground(new Color(255, 255, 255));

				// winCountLabel.setBackground(new Color(0, 0, 0));
				// winCountLabel.setForeground(new Color(0, 0, 0));

				Dimension minimumSize = new Dimension(700, 90);
				setMaximumSize(minimumSize);
				setMinimumSize(minimumSize);

				panelStatsLayout.setHorizontalGroup(panelStatsLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(winCountLabel, 100, 100, 100)
				// .addGroup(
				// panelStatsLayout.createSequentialGroup().addGap(70)
				// .addComponent(winCountLabel, 100, 100, 100).addGap(50)
				// .addComponent(loseCountLabel, 100, 100, 100).addGap(50)
				// .addComponent(losePercentageLabel, 100, 100, 100))
				// .addGroup(
				// panelStatsLayout.createSequentialGroup().addGap(70)
				// .addComponent(winCountValue, 60, 60, 60).addGap(50)
				// .addComponent(loseCountValue, 60, 60, 60).addGap(50)
				// .addComponent(winPercentageValue, 60, 60, 60))
						);

				panelStatsLayout.setVerticalGroup(panelStatsLayout
						.createSequentialGroup().addGap(50)
						.addComponent(winCountLabel, 100, 100, 100)
				// .addGroup(
				// panelStatsLayout.createParallelGroup().addGap(70)
				// .addComponent(winCountLabel, 100, 100, 100)
				// .addComponent(loseCountLabel, 100, 100, 100)
				// .addComponent(losePercentageLabel, 100, 100, 100))
				// .addGap(20)
				// .addGroup(
				// panelStatsLayout.createParallelGroup().addGap(70)
				// .addComponent(winCountValue, 60, 60, 60)
				// .addComponent(loseCountValue, 60, 60, 60)
				// .addComponent(winPercentageValue, 60, 60, 60))
						);

			}
		}
	}

	public void setDoubledText() {
		theOpponent.setDoubleText();
		theUser.setDoubleText();
	}

	public void createBettingPopUp() {
		BettingPopUp newBet = new BettingPopUp();
	}

	public void forfeitGame() {
		Home_Screen homescreen = new Home_Screen(user);
		dispose();
	}

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
	public void addDoubleListener(ActionListener doubleListener) {
		this.buttonDouble.addActionListener(doubleListener);
	}

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
	public void addPlayHandListener(ActionListener playHandListener) {
		this.buttonPlay.addActionListener(playHandListener);

	}

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
	public void addForfeitListener(ActionListener forfeitListener) {
		this.buttonForfeit.addActionListener(forfeitListener);

	}

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
	public void addSwapTilesListener(ActionListener swapTilesListener) {
		this.buttonSwap.addActionListener(swapTilesListener);
	}

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
	public void setGameBoardTableModel() {
		// TODO Auto-generated method stub

	}

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
	public void setCurrentHandTableModel(ArrayList<Tile> drawTiles) {
		this.theCurrentHand.setInitialBoardModel(drawTiles);
	}

}
