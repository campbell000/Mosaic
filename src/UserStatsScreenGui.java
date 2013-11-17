

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UserStatsScreenGui extends JFrame
{
	Container contents = this.getContentPane();
	JPanel userInfo;
	JPanel opponentInfo;

	
	User user;
	
	public UserStatsScreenGui(User user)
	{
		userInfo = new JPanel();
		opponentInfo = new JPanel();
		this.user = user;
		initializeGUI();
	}
	
	private void initializeGUI()
	{
		//Separate Jframe into two parts: user info and opponent info
		contents.setLayout(new GridLayout(1, 1));
		
		//Add components and functionality
		fillUserInfoPanel();
		fillOpponentPanel();
		
		//Set Properties of Check Stats GUI
		setResizable(false);
		setTitle("User Statistics for "+user.getUsername());
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	
		
		// ----------------------ARMANDO
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//Fill in the info on the left side of the screen
	private void fillUserInfoPanel()
	{
		Font f = new Font("veranda", Font.BOLD, 20);
		
		//set up border
		userInfo.setLayout(new GridLayout(2, 1));
		userInfo.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "User Statistics for: "+user.getUsername(),
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
		//display account info
		JPanel userAccountInfo = new JPanel();
		userAccountInfo.setLayout(new GridLayout(2, 1));
		JLabel eLabel = new JLabel("Email Address: "+user.getEmail());
		userAccountInfo.add(eLabel);
		userAccountInfo.add(new JLabel("Password: "+user.getPassword()));
		
		//display personal statistics
		JPanel userRecords = new JPanel();
		userRecords.setLayout(new GridLayout(4, 1));
		userRecords.add(new JLabel("Wins: "+user.getWins()));
		userRecords.add(new JLabel("Losses: "+(user.getLosses())));
		userRecords.add(new JLabel("Win Percentage: "+user.getWinPercentage()));
		JButton goBack = new JButton("Go Back");
		
		
		
		//Add goback button
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				
				dispose();
			}
		});
		
		
		
		
		
		goBack.setSize(20, 20);
		userRecords.add(goBack);
		
		userInfo.add(userAccountInfo);
		userInfo.add(userRecords);
		
		//Apply font to all components
		Component [] comps = userInfo.getComponents();
		for (int i = 0; i < comps.length; i++)
		{
			JPanel j = (JPanel) comps[i];
			Component[] cs = j.getComponents();
			for (int k = 0; k < cs.length; k++)
				cs[k].setFont(f);
		}
		contents.add(userInfo);
	}
	
	//Fill in the right side of screen with opponent statistics.
	private void fillOpponentPanel()
	{
		//Add border
		JPanel opponentInfo = new JPanel();
		opponentInfo.setLayout(new BorderLayout());
		opponentInfo.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "10 Most Recent Opponents:",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		
		//Setup JTable with user opponent records
		String [] titles = {"Name:", "Wins:", "Losses:", "Last Played On:"};
		JTable recordTable = new JTable(user.getOpponentRecordArray(), titles);
		recordTable.setName("Recent Opponents:");
		recordTable.setEnabled(false);
		recordTable.setRowHeight(40);
		
		//create scroll pane so that column names appear:
		JScrollPane pane = new JScrollPane(recordTable);
		opponentInfo.add(pane);
		
		contents.add(opponentInfo);
	}

}
