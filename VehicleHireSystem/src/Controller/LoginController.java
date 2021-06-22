package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.Login;
import View.LoginView;
import View.StaffAddCustomerView;

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
		
		if (e.getSource().equals(this.view.getStaffButton())) {
			if (login.authStaff(user, password)){
				this.view.setSuccessText();
				StaffAddCustomerView staffCView = new StaffAddCustomerView();
				this.view.setNextView(staffCView);
			}
			else {
				this.view.setFailText();
			}
		} else {
			//Authenticate customer
		}
	}

}
