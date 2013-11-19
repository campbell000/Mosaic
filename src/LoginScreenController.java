import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is generic code for a class
 * 
 * @author Armando Benavidez
 * @version 1.0
 */

public class LoginScreenController {

	private LoginScreenGui loginScreen;

	public GameBoardController(LoginScreenGui loginScreen){
		this.loginScreen = loginScreen;
		
		this.loginScreen.addLoginListener( new LoginListener());
		this.loginScreen.addQuitListener(new QuitListener()):
		this.loginScreen.addSignUpListener(new SignUpListener());
		this.loginScreen.addRememberUserNameListener(new RememberUserNameListener());
		
	}

	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loginAttempt) {
			// TODO Auto-generated method stub
		}
	}

}
