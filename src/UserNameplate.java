import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * This is generic code for a class
 * 
 * @author Armando Benavidez
 * @version 1.0
 */

public class UserNameplate extends JPanel {

    private JLabel userName;
    private JLabel userScore;
    private JLabel userDouble;

    private int userDoubleValue;
    
    // End of variables declaration   
    
	 /**
	 * *******Generic Description*******************
	 *
	 * @param Generic comment
	 * @param Generic Comment
	 * @return  Generic Comment
	 */  
	public UserNameplate() {
		// Variables declaration - do not modify       
		userName = new JLabel("Username");
		userScore = new JLabel("Score: 000 299");

		userDouble = new JLabel();
		userDoubleValue = 0;
		
		userName.setFont(new java.awt.Font("Aharoni", 0, 18));

		userScore.setFont(new java.awt.Font("Aharoni", 0, 36));
		userScore.setText("0000600");
      
        userDouble.setVisible(false);
        userDouble.setFont(new java.awt.Font("Aharoni", 0, 15));
        

		setBackground(new Color(255, 255, 255));
		setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
		
		Dimension minimumSize = new Dimension(360, 90);
		setMaximumSize(minimumSize);
		setMinimumSize(minimumSize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                	.addGap(20)
                	.addGroup(layout.createSequentialGroup()
                			.addGap(10)
                			.addComponent(userName, 159, 159, 159)
                			.addGap(25)
                    		.addComponent(userDouble, 120, 120, 120)
                			)
                    .addGroup(layout.createSequentialGroup()
                    		.addGap(190)
                    		.addComponent(userScore, 132, 132, 132)
                    		.addGap(15, 15, 15)
                    		)
                    .addGap(20)
            );
            layout.setVerticalGroup(
                layout.createSequentialGroup()
                	.addGroup(layout.createParallelGroup()
            			.addComponent(userName, 39, 39, 39)
    					.addComponent(userDouble, 30, 30, 30)  
        			)
        			.addComponent(userScore, 20, 20 ,20)
                    .addGap(10)
            );
        
	}

   public void setDoubleText(){
      userDoubleValue += 2;
      userDouble.setVisible(true);
      userDouble.setText("x" + userDoubleValue + " Win/Lose");
   }

}