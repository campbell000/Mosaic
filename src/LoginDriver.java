

import javax.swing.UIManager;

public class LoginDriver {
	
	public static void main (String[] args) throws Exception
	{
		UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    
		//MAKE SURE SCREENS CLOSE
		
		
		
		LoginScreenController login = new LoginScreenController(
				new LoginScreenGui());
		
		//User user = new User();
		//UserStatsScreenGui statScreen = new UserStatsScreenGui(user);
		//Home_Screen h = new Home_Screen();
		//GameBoardInstance test = new GameBoardInstance();
	}

}
