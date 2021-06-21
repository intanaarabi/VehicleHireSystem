package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.Login;
import View.LoginView;

public class LoginController implements ActionListener {

	private LoginView view;
	private Login login;
	private JFrame main;
	
	public LoginController(Login login, JFrame main) {
		this.login = login;
		this.main = main;
	}
	
	public void addView(LoginView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = this.view.getUsername();
		String password = this.view.getPassword();
		
		if (e.getSource().equals(this.view.getStaffButton())) {
			if (login.authStaff(user, password)){
				this.view.setSuccessText();
				
			}
			else {
				this.view.setFailText();
			}
		}
	}

}
