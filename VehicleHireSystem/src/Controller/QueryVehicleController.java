package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import Model.Vehicle;
import View.StaffAddCustomerView;
import View.StaffAddLorryView;
import View.LoginView;
import View.StaffAddBusView;
import View.StaffAddCarView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;

public class QueryVehicleController  implements ActionListener{

	private StaffQueryVehicleView view;
	private HireSystem system = new HireSystem();

	public QueryVehicleController() {
	}
	
	public void addView(StaffQueryVehicleView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.view.getAddCarButton())) {
			StaffAddCarView newView = new StaffAddCarView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getAddBusButton())){
			StaffAddBusView newView = new StaffAddBusView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getAddLorryButton())) {
			StaffAddLorryView newView = new StaffAddLorryView();
			this.view.setNextView(newView);
		} else if (e.getSource().equals(this.view.getCustomersButton())) {
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
		} else if (e.getSource().equals(this.view.getRemoveVehicleBtn())) {
			String vehicleRegNo = this.view.getDelVehRegNo();
			this.system.removeVehicle(vehicleRegNo);
			StaffQueryVehicleView newView = new StaffQueryVehicleView();
			this.view.setNextView(newView);
			this.view.setSuccessText("Vehicle successfully removed.");
		} else if (e.getSource().equals(this.view.getHireButton())) {
			String vehicleRegNo = this.view.getDelVehRegNo();
			String customerId = this.view.getCustId();
			
			if(this.system.checkCustExist(customerId)) {
				CorporateCustomer customer = this.system.getCustomer(customerId);
				Vehicle vehicle = this.system.getVehicle(vehicleRegNo);
				customer.addVehicle(vehicle);
				this.system.removeVehicle(vehicleRegNo);
				this.system.updateCustomer(customer);
				StaffQueryVehicleView newView = new StaffQueryVehicleView();
				this.view.setNextView(newView);
				this.view.setSuccessText("Successfully Hired Vehicle for Customer");
			}else {
				this.view.setSuccessText("No Customer associated with given Id.");
			}
			
		}

}
}
