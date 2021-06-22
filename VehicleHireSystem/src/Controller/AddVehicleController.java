package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Bus;
import Model.Car;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Login;
import Model.Lorry;
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
				
		} else if(this.vehicleType.equals("Bus")) {
			if (e.getSource().equals(this.busview.getSaveButton())) {
				String busReg = this.busview.getbRegNoText();
				String busMake = this.busview.getbMakeText();
				String busModel = this.busview.getbModelText();
				String busSpeed = this.busview.getbSpeedText();
				String busHire = this.busview.getbRateText();
				String busSeatCap = this.busview.getMaxCap();
				
				Bus newBus = new Bus(busMake,busModel,Integer.valueOf(busSpeed),busReg,Integer.valueOf(busHire),Integer.valueOf(busSeatCap));
				
				if(this.system.addBus(newBus)) {
					this.busview.setSuccessText("New Bus Added Successfully.");
				}else {
					this.busview.setSuccessText("Vehicle with specified Reg. No. already exists.");
				}
				
				
			} else if (e.getSource().equals(this.busview.getCustomersButton())) {
				StaffQueryCustomerView newView = new StaffQueryCustomerView();
				this.busview.setNextView(newView);
			} else if (e.getSource().equals(this.busview.getVehiclesButton())) {
				StaffQueryVehicleView newView = new StaffQueryVehicleView();
				this.busview.setNextView(newView);
			} else if (e.getSource().equals(this.busview.getLogoutButton())) {
				Login login = new Login();
				LoginController loginController = new LoginController(login);
				LoginView newView = new LoginView(loginController);
				this.busview.setNextView(newView);
			}
		} else {
			if (e.getSource().equals(this.lorryview.getSaveButton())) {
				String LorryReg = this.lorryview.getlRegNoText();
				String LorryMake = this.lorryview.getlMakeText();
				String LorryModel = this.lorryview.getlModelText();
				String LorrySpeed = this.lorryview.getlSpeedText();
				String LorryHire = this.lorryview.getlRateText();
				String LorryLoadCap = this.lorryview.getMaxWeight();
				
				Lorry newLorry = new Lorry(LorryMake,LorryModel,Integer.valueOf(LorrySpeed),LorryReg,Integer.valueOf(LorryHire),Integer.valueOf(LorryLoadCap));
				
				if(this.system.addLorry(newLorry)) {
					this.lorryview.setSuccessText("New Lorry Added Successfully.");
				}else {
					this.lorryview.setSuccessText("Vehicle with specified Reg. No. already exists.");
				}
				
				
			} else if (e.getSource().equals(this.lorryview.getCustomersButton())) {
				StaffQueryCustomerView newView = new StaffQueryCustomerView();
				this.lorryview.setNextView(newView);
			} else if (e.getSource().equals(this.lorryview.getVehiclesButton())) {
				StaffQueryVehicleView newView = new StaffQueryVehicleView();
				this.lorryview.setNextView(newView);
			} else if (e.getSource().equals(this.lorryview.getLogoutButton())) {
				Login login = new Login();
				LoginController loginController = new LoginController(login);
				LoginView newView = new LoginView(loginController);
				this.lorryview.setNextView(newView);
			}
		}
	}

}
