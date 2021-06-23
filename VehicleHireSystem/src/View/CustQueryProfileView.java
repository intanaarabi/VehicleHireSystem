package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.CustProfileController;
import Controller.CustVehicleController;
import Model.Bus;
import Model.Car;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Lorry;
import Model.Vehicle;

public class CustQueryProfileView extends View {
	
	private JLabel welcomeCustomer, details, vehicleListing;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private String username;
	private CustProfileController controller;

	public CustQueryProfileView(String username) {
		
		HireSystem system = new HireSystem();

		this.username = username;
		this.controller = new CustProfileController(this.username);
		this.controller.addView(this);
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setTitle("Vehicle Hire System");

		
		CorporateCustomer customer = system.getCustomerUser(username);
		
		
		Object cTable[][] = {{customer.getCustomerId(),customer.getCustomerCorpName(),customer.getCustomerAddr(),customer.getCustomerPhoneNo(),customer.getCustomerEmail()}};
		
		
		ArrayList<Vehicle> vehicleList = customer.getHiredVehicles();
		Object[][] vTable = new Object[vehicleList.size()][];
		for(int i =0; i<vehicleList.size();i++) {
			String vType;
			if (vehicleList.get(i) instanceof Car) {
				vType = "Car";
			} else if (vehicleList.get(i) instanceof Bus) {
				vType = "Bus";
			} else {
				vType = "Lorry";
			}
			vTable[i] = new Object[] {
					vType,
					vehicleList.get(i).getVehicleRegNo(),
					vehicleList.get(i).getVehicleModel(),
					vehicleList.get(i).getVehicleMake(),
					vehicleList.get(i).getVehicleTopSpeed(),
					vehicleList.get(i).getVehicleDailyHireRate(),
			};
		}
		
		
		JTable custTable = new JTable(cTable,new String[] {"Cust. ID", "Cust. Name","Cust. Addr","Cust. Phone", "Cust. Email"});
		JTable vehicleTable = new JTable(vTable,new String[] {"Type", "Reg. No","Model","Make", "Top Speed","Daily Hire Rate"});
		JPanel custPanel = new JPanel();
		JPanel vehiclePanel = new JPanel();
		
		JPanel pTop = new JPanel();
		pTop.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		pTop.setLayout(new GridLayout(0,4));
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		mainPanel.setLayout(new GridLayout(0,1));
		custPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		custPanel.setLayout(new BorderLayout());
		vehiclePanel.setLayout(new BorderLayout());
		vehiclePanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		
		welcomeCustomer = new JLabel("Welcome " + this.username);
		welcomeCustomer.setBounds(10, 80, 80, 25);
		pTop.add(welcomeCustomer);
		
		vehiclesButton = new JButton("Query Vehicles");
		vehiclesButton.setBounds(10, 80, 80, 25);
		vehiclesButton.addActionListener(this.controller);
		pTop.add(vehiclesButton);
		
		customersButton = new JButton("View Profile");
		customersButton.setBounds(10, 80, 80, 25);
		customersButton.addActionListener(this.controller);
		pTop.add(customersButton);
		
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(40, 80, 80, 25);
		logoutButton.addActionListener(this.controller);
		pTop.add(logoutButton);
		
		details = new JLabel("Details");
		custPanel.add(details,BorderLayout.NORTH);
		
		vehicleListing = new JLabel("Vehicle(s) Currently Hired");
		vehiclePanel.add(vehicleListing,BorderLayout.NORTH);
		
		vehiclePanel.add(new JScrollPane(vehicleTable),BorderLayout.CENTER);
		
		custPanel.add(new JScrollPane(custTable),BorderLayout.CENTER);
		mainPanel.add(custPanel);
		mainPanel.add(vehiclePanel);
		
		frame.add(pTop,BorderLayout.NORTH);
		frame.add(mainPanel,BorderLayout.CENTER);

		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
		this.controller.addView(this);
		
		
	}
	
	public JButton getVehiclesButton() {
		return this.vehiclesButton;
	}
	public JButton getCustomersButton() {
		return this.customersButton;
	}
	public JButton getLogoutButton() {
		return this.logoutButton;
	}
	

}
