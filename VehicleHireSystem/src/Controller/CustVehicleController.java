package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Login;
import View.CustQueryProfileView;
import View.CustQueryVehicleView;
import View.LoginView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;

public class CustVehicleController implements ActionListener{
	
	
	CustQueryVehicleView view;
	String userId;

	public CustVehicleController(String userId) {
		this.userId = userId;
	}


	public void addView(CustQueryVehicleView custQueryVehicleView) {
		this.view = custQueryVehicleView;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.view.getCustomersButton())) {
			CustQueryProfileView newView = new CustQueryProfileView(this.userId);
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getVehiclesButton())) {
			CustQueryVehicleView newView = new CustQueryVehicleView(this.userId);
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getLogoutButton())) {
			Login login = new Login();
			LoginController loginController = new LoginController(login);
			LoginView newView = new LoginView(loginController);
			this.view.setNextView(newView);
		}
		
	}


}
