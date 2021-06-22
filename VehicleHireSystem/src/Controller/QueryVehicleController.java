package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.HireSystem;
import Model.Login;
import View.StaffAddCustomerView;
import View.LoginView;
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
	}

}
}
