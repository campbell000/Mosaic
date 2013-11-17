

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginDriver {
	
	public static void main (String[] args) throws Exception
	{
		UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    
		//MAKE SURE SCREENS CLOSE
		
		
		
		LoginScreenGui login = new LoginScreenGui();
		
		//User user = new User();
		//UserStatsScreenGui statScreen = new UserStatsScreenGui(user);
		//Home_Screen h = new Home_Screen();
		//GameBoardInstance test = new GameBoardInstance();
	}

}
