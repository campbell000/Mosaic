

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Home_Screen extends JFrame{
	
	public Home_Screen(){
      
		//Container for everything
		Container contents = this.getContentPane();
		JFrame container = new JFrame("Mosiac Game Menu");
		JPanel everything = new JPanel();
		everything.setLayout(new BorderLayout());
		setSize(800, 600);
      
		//Logo Element, currently as button
		JPanel logo = new JPanel();
		JButton logoB = new JButton();
		logoB.setIcon(new ImageIcon(getClass().getResource("resources/mosaicButtonBanner.jpg")));
		logoB.setPreferredSize(new Dimension(600, 200));
		logo.add(logoB);
		setLayout(new BorderLayout());
		
		//First button for Invites
		JPanel options = new JPanel();
		options.setBorder(new EmptyBorder(10, 20, 10, 20));
		JButton option1 = new JButton("Invite");
		option1.setFont(new Font("veranda", Font.BOLD, 25));
		option1.addActionListener(new InviteListener());
		//option1.setPreferredSize(new Dimension(600, 100));
		
		//Second button for Check Invites
		JButton option2 = new JButton("Check Invites");
		option2.setFont(new Font("veranda", Font.BOLD, 25));
		option2.addActionListener(new InviteCheckListener());
		
		JButton option3 = new JButton("Check Stats");
		option3.setFont(new Font("veranda", Font.BOLD, 25));
		option3.addActionListener(new statListener());
		/**
		option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	option3ActionPerformed(evt);
            }
        });
        */
		
		
		
		options.setLayout(new GridLayout(3,1));
		options.add(option1);
		options.add(option2);
		options.add(option3);
		
		everything.add(logo, BorderLayout.PAGE_START);
		everything.add(options, BorderLayout.CENTER);
		
		everything.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "MOSAIC Home Screen",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
		contents.add(everything);
		setLocationRelativeTo(null);
		setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	// ------------------------------------------------ ARMANDO WAS HERE -----------------------------------------------------------------------
	/**
	 * description sentence <code></code>
	 *
	 * <p>description paragraph</p>
	 *
	 * @param
	 * @param
	 * @return
	 */
	/**
	protected void option3ActionPerformed(ActionEvent evt) {
		//setVisible(false);		
		
		User user = new User();
		UserStatsScreenGui statScreen = new UserStatsScreenGui(user);
	}
	 */
	public class InviteListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame message = new JFrame();
			
			JOptionPane.showInputDialog(message, "Enter Username of Player: ");
			
		}
		
	}
	
	
	public class InviteCheckListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			makeInvitePopup();
		}
	
	} // end of listener class
		
	private void makeInvitePopup()
	{
		// TODO Auto-generated method stub
		JFrame invitepop = new JFrame("Current Invitations");
		invitepop.setLayout(new BorderLayout());
		invitepop.setSize(new Dimension(600, 400));
		
		JPanel inviteList = new JPanel();
		inviteList.setLayout(new GridLayout(5, 1));
		//for the number of invites
		//add invites to invite panel
		
		
		//Invite
		JPanel invite = new JPanel();
		invite.setLayout(new GridLayout(1, 3));
		
		JTextField invitee = new JTextField("George Walkin");
		invitee.setEditable(false);
		invite.add(invitee);
		
		JButton yes = new JButton("Accept");
		yes.addActionListener(new acceptListener(invite, invitepop));
		JButton no = new JButton("Decline");
		no.addActionListener(new declineListener(invite));
		
		invite.add(yes);
		invite.add(no);
		
		inviteList.add(invite);
		
		
		//Another invite
		JPanel invite2 = new JPanel();
		invite2.setLayout(new GridLayout(1, 3));
		
		JTextField invitee2 = new JTextField("Sandy Kins");
		invitee2.setEditable(false);
		invite2.add(invitee2);
		
		JButton yes2 = new JButton("Accept");
		yes2.addActionListener(new acceptListener(invite2, invitepop));
		JButton no2 = new JButton("Decline");
		no2.addActionListener(new declineListener(invite2));
		
		invite2.add(yes2);
		invite2.add(no2);
		
		inviteList.add(invite2);
		
		invitepop.add(inviteList, BorderLayout.CENTER);
		invitepop.setVisible(true);		
		invitepop.setLocationRelativeTo(null);
      invitepop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}	
	
	public class statListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//This code should go to check stat menu
			User user = new User("Alex Campbell", "hunter2", "ascampbell@loyola.edu");
			UserStatsScreenGui statScreen = new UserStatsScreenGui(user);
		}
		
	}
	public class acceptListener implements ActionListener{

      JFrame invitePopup;
		JPanel x;
		acceptListener(JPanel y, JFrame j)
      {
         invitePopup = j;
			x = y;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			startGame(invitePopup);
		}
		public void remove(){
			x.removeAll();
			x.setVisible(false);
		}
		
	} // end of accept listener
   
   public void startGame(JFrame popup)
   {
      int userSelection;
			
		// ------------------------------------------------ ARMANDO WAS HERE -----------------------------------------------------------------------
		userSelection = JOptionPane.showOptionDialog(null, "Now it's time to play!", "Game Start!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
			
      //ALEX WAS HERE
		//when ok is selected, close all windows, and open a game window
		if(userSelection == 0){
         this.setVisible(false);
         this.dispose();
         popup.setVisible(false);
         popup.dispose();
			GameBoardInstance gameBoard = new GameBoardInstance();
		}
   }
	
	public class declineListener implements ActionListener{
		
	JPanel x;
	declineListener(JPanel y){
		x = y;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame popup = new JFrame();
		
		JOptionPane.showMessageDialog(popup, "Invitation Declined. Please refresh page");
		remove();
		
	}
	
	public void remove(){
		x.removeAll();
		x.setVisible(false);
	}
	}
	
}


