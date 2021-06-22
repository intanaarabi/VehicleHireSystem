package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import View.LoginView;
import View.StaffAddCustomerView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;

public class QueryCustController implements ActionListener {
	
	
	private StaffQueryCustomerView view;

	public QueryCustController() {
	}
	
	public void addView(StaffQueryCustomerView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.view.getAddCustButton())) {
			StaffAddCustomerView newView = new StaffAddCustomerView();
			this.view.setNextView(newView);
		}  else if (e.getSource().equals(this.view.getCustomersButton())) {
			StaffQueryCustomerView newView = new StaffQueryCustomerView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getVehiclesButton())) {
			StaffQueryVehicleView newView = new StaffQueryVehicleView();
			this.view.setNextView(newView);
	}else if (e.getSource().equals(this.view.getLogoutButton())) {
		Login login = new Login();
		LoginController loginController = new LoginController(login);
		LoginView newView = new LoginView(loginController);
		this.view.setNextView(newView);
	
}
	
	
}
}
