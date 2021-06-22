package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Car;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import View.LoginView;
import View.StaffAddBusView;
import View.StaffAddCarView;
import View.StaffAddCustomerView;
import View.StaffAddLorryView;
import View.StaffQueryCustomerView;
import View.StaffQueryVehicleView;
import View.View;

public class AddVehicleController implements ActionListener {

	private HireSystem system;
	private StaffAddCarView carview;
	private StaffAddBusView busview;
	private StaffAddLorryView lorryview;
	private String vehicleType;


	public AddVehicleController(HireSystem system, String vehicleType) {
		this.system = system;
		this.vehicleType = vehicleType;
	}
	
	public void addCarView(StaffAddCarView view) {
		this.carview = view;
	}
	
	public void addBusView(StaffAddBusView view) {
		this.busview = view;
	}
	
	public void addLorryView(StaffAddLorryView view) {
		this.lorryview = view;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.vehicleType.equals("Car")) {
			if (e.getSource().equals(this.carview.getSaveButton())) {
				String carReg = this.carview.getcRegNoText();
				String carMake = this.carview.getcMakeText();
				String carModel = this.carview.getcModelText();
				String carSpeed = this.carview.getcSpeedText();
				String carHire = this.carview.getcRateText();
				String carFuel = this.carview.getcFuelTypeText();
				String carDoors = this.carview.getcDoorsText();
				Car newCar = new Car(carMake,carModel,Integer.valueOf(carSpeed),carReg,Integer.valueOf(carHire),carFuel,Integer.valueOf(carDoors));

				if(this.system.addCar(newCar)) {
					this.carview.setSuccessText("New Car Added Successfully.");
				}else {
					this.carview.setSuccessText("Vehicle with specified Reg. No. already exists.");
				}
				
				
			} else if (e.getSource().equals(this.carview.getCustomersButton())) {
				StaffQueryCustomerView newView = new StaffQueryCustomerView();
				this.carview.setNextView(newView);
			} else if (e.getSource().equals(this.carview.getVehiclesButton())) {
				StaffQueryVehicleView newView = new StaffQueryVehicleView();
				this.carview.setNextView(newView);
			} else if (e.getSource().equals(this.carview.getLogoutButton())) {
				Login login = new Login();
				LoginController loginController = new LoginController(login);
				LoginView newView = new LoginView(loginController);
				this.carview.setNextView(newView);
			}
				
		}
	}

}
