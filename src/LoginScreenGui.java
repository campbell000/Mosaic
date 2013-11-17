

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginScreenGui extends JFrame
{
	Container contents = getContentPane();
	JPanel logo;
	JPanel screenInterface;
	final String LOGO_PATH = "media/temp.png";
	final String CREATE_ACCT_PATH = "media/temp2.png";
	JTextField usernameField;
	JTextField password;
	
	public LoginScreenGui()
	{
		//The GUI is set into two parts: the logo(top half), and the interface(bottom half)
		logo = new JPanel();
		screenInterface = new JPanel();
		contents.setLayout(new GridLayout(2, 1, 20, 20));
		
		//fill up both parts and add to the content container
		initializeGUI();
		contents.add(logo);
		contents.add(screenInterface);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initializeGUI()
	{
		//Add components and their functionality
		fillUpInterface();
		fillUpLogo();
		
		//Set properties of GUI
		setResizable(false);
		setTitle("Login to the Mosaic Game network to get started!");
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	//Adds interface and functionality to interface components
	private void fillUpInterface()
	{
		/**
		 * This section of the GUI is made up of 4 parts:
		 * 1. Username field
		 * 2. Password field
		 * 3. remember user info box
		 * 4. buttons
		 */

		JPanel interfaceComponents = new JPanel();
		interfaceComponents.setLayout(new GridLayout(5, 1, 10, 10));
		JPanel buttons = new JPanel();
		
		//create username field and clear text on click
		usernameField = new JTextField("Username");
		usernameField.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e){
	                usernameField.setText("");
	         }
		});
		
		//create password field and clear text on click
		password = new JTextField("Password");
		password.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e){
	                password.setText("");
	         }
		});
		
		//create login button and add action listener
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				String username = usernameField.getText();
				String pass = password.getText();
				login(username, pass);
			}
		});
		
		//Create Quit button and add action listener
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		
		//Create sign up button and add action listener
		JButton signup = new JButton("Don't have an account? Sign up here!");
		signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				signUp();
			}
		});
		JCheckBox rememberInfo = new JCheckBox("Remember my login details");
		
		buttons.add(login);
		buttons.add(quit);
		
		interfaceComponents.add(usernameField);
		interfaceComponents.add(password);
		interfaceComponents.add(rememberInfo);
		interfaceComponents.add(buttons);
		interfaceComponents.add(signup);
		
		screenInterface.add(interfaceComponents);

	}
	
	private void fillUpLogo()
	{
		addPictureToComponent(LOGO_PATH, logo);
	}
	
	private void addPictureToComponent(String path, JPanel component)
	{
		System.out.println(System.getProperty("user.dir"));
		/**
		//Load picture
		File file = new File(path);
		BufferedImage pic = null;
		try 
		{
			pic = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		*/
		
		// ------------------------------------------------ ARMANDO WAS HERE -----------------------------------------------------------------------
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource("resources/mosaicMainbanner.jpg")));
		component.add(label);	
	}
	
	//
	private void login(String username, String password) 
	{
		//Actually check data against server, create user object
		//System.out.println("Login: Not implemented");
		int userSelection;
		
		// ------------------------------------------------ ARMANDO WAS HERE -----------------------------------------------------------------------
		userSelection = JOptionPane.showOptionDialog(null, "Hello, "+username+"!", "Login Welcome", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		
		//when ok is selected
		if(userSelection == 0)
      {
		   Home_Screen h = new Home_Screen();
			this.setVisible(false);
         this.dispose();       
		}
		
	}
	
	public void signUp()
	{
		makeAccountPopUp();
	}
	
	public void makeAccountPopUp()
	{
		//Set up popup window properties
		final JFrame createAccount = new JFrame();
		JPanel accountInterface = new JPanel();
		accountInterface.setBorder(new EmptyBorder(20, 20, 20, 20));
		accountInterface.setLayout(new GridLayout(6, 1, 30, 15));
		
		//Add picture
		JPanel image = new JPanel();
		JLabel pictureComp = new JLabel();
		
		// ------------------------------------------------ ARMANDO WAS HERE -----------------------------------------------------------------------
		pictureComp.setIcon(new ImageIcon(getClass().getResource("resources/mosaicRegBanner.jpg")));
				
		//addPictureToComponent("resources/mosaicRegBanner.jpg", image);
		accountInterface.add(pictureComp);
		
		//Create username panel and add it to interface
		JPanel username = new JPanel();
		username.setLayout(new GridLayout(2, 1, 0, -05));
		JLabel usernameLabel = new JLabel("Username:");
		final JTextField usernameField = new JTextField();
		username.add(usernameLabel);
		username.add(usernameField);
		accountInterface.add(username);
		
		//Create email panel and add it to interface
		JPanel email = new JPanel();
		email.setLayout(new GridLayout(2, 1, 0, -05));
		JLabel emailLabel = new JLabel("Email:");
		final JTextField emailField = new JTextField();
		email.add(emailLabel);
		email.add(emailField);
		accountInterface.add(email);
		
		//Create password panel and add it to interface
		JPanel password = new JPanel();
		password.setLayout(new GridLayout(2, 1, 0, -05));
		JLabel passwordLabel = new JLabel("Password:");
		final JTextField passwordField = new JTextField();
		password.add(passwordLabel);
		password.add(passwordField);
		accountInterface.add(password);
		
		//Create verifyEmail panel and add it to interface
		JPanel verifyEmail = new JPanel();
		verifyEmail.setLayout(new GridLayout(2, 1, 0, -05));
		JLabel verifyEmailLabel = new JLabel("Verify Email:");
		final JTextField verifyEmailField = new JTextField();
		verifyEmail.add(verifyEmailLabel);
		verifyEmail.add(verifyEmailField);
		accountInterface.add(verifyEmail);
		
		//Create signup and cancel buttons, add listeners to them.
		JPanel buttons = new JPanel();
		buttons.setBorder(new EmptyBorder(10, 20, 10, 20));
		
		//Setup signup button functionality
		buttons.setLayout(new GridLayout(1, 2, 10, 0));
		buttons.setBorder(new EmptyBorder(20, 20, 10, 10));
		JButton signup = new JButton("Sign me Up!");
		
		//Functionality: get text from all fields, sign up user, close window
		signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) 
			{
				String username = usernameField.getText();
				String password = passwordField.getText();
				String email = emailField.getText();
				String verifyEmail = verifyEmailField.getText();
				if (verifyInfo(username, password, email, verifyEmail))
				{
					createAccount();
					createAccount.dispatchEvent(new WindowEvent(createAccount, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		
		//set up cancel button: close window on click
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				createAccount.setVisible(false);
            createAccount.dispose();
			}
		});
		
		buttons.add(signup);
		buttons.add(cancel);
		accountInterface.add(buttons);
		
		//set properties of popup window
		createAccount.getContentPane().add(accountInterface);
		createAccount.setSize(300, 500);
		createAccount.setVisible(true);
		createAccount.setResizable(false);
		createAccount.setLocationRelativeTo(null);
	}
	
	private void createAccount()
	{
		System.out.println("createAccount: not Implemented");
		JOptionPane.showMessageDialog(null, "Account created!");
	}
	
	private boolean verifyInfo(String username, String password, String email, String verifyEmail)
	{
		boolean valid = true;
		
		System.out.println("Verify Info: Not implemented");
		System.out.println(username+" "+password+" "+email+" "+verifyEmail);
		if (!email.equals(verifyEmail))
		{
			JOptionPane.showMessageDialog(null, "The email addresses do not match!");
			valid = false;
		}
		
		return valid;
	}
}
