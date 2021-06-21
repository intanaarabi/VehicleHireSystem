package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView implements ActionListener {
	
	private static JLabel usernameLabel;
	private static JTextField usernameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel loginSuccess;
	
	
	public LoginView() {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		panel.setLayout(new GridLayout(0,1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.pack();
		frame.setVisible(true);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 20, 80, 25);
		panel.add(usernameLabel);
		
		usernameText = new JTextField(20);
		usernameText.setBounds(100, 20, 165, 25);
		panel.add(usernameText);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new LoginView());
		panel.add(button);
		
		loginSuccess = new JLabel("");
		loginSuccess.setBounds(10, 110, 300, 25);
		panel.add(loginSuccess);
		
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = usernameText.getText();
		String password = passwordText.getText();
		System.out.println(user + ", " + password);
		
		if(user.equals("test") && password.equals("test")) {
			loginSuccess.setText("login successful!");
		}
		
	}

}
