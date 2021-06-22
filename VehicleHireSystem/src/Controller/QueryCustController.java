package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.Car;
import Model.Bus;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import Model.Lorry;
import Model.Vehicle;
import View.LoginView;
import View.StaffAddCustomerView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;

public class QueryCustController implements ActionListener {
	
	
	private StaffQueryCustomerView view;
	private HireSystem system = new HireSystem();


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
		} else if (e.getSource().equals(this.view.getLogoutButton())) {
			Login login = new Login();
			LoginController loginController = new LoginController(login);
			LoginView newView = new LoginView(loginController);
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getReturnButton())) {
			String vehRegNo = this.view.getVehRegNo();
			String custId = this.view.getCustId();
			CorporateCustomer customer = this.system.getCustomer(custId);
			if (customer.getVehicle(vehRegNo) instanceof Car) {
				this.system.addCar((Car) customer.getVehicle(vehRegNo));
			} else if (customer.getVehicle(vehRegNo) instanceof Bus) {
				this.system.addBus((Bus) customer.getVehicle(vehRegNo));
			} else {
				this.system.addLorry((Lorry) customer.getVehicle(vehRegNo));
			}
			this.system.setVehicles();
			customer.returnVehicle(customer.getVehicle(vehRegNo));
			this.system.updateCustomer(customer);
			StaffQueryCustomerView newView = new StaffQueryCustomerView();
			this.view.setNextView(newView);
			this.view.setSuccessText("Successfully Returned Vehicle for Customer");
			
		}
	
	
}
}
