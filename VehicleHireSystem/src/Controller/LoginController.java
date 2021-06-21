package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Login;
import View.LoginView;

public class LoginController implements ActionListener {

	private LoginView view;
	private Login login;
	
	public LoginController(Login login) {
		this.login = login;
	}
	
	public void addView(LoginView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = this.view.getUsername();
		String password = this.view.getPassword();
		
		if (login.authStaff(user, password)){
			this.view.setSuccessText();
		}
		else {
			this.view.setFailText();
		}
	}

}
