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

import Controller.CustVehicleController;
import Controller.QueryCustController;
import Model.Bus;
import Model.Car;
import Model.HireSystem;
import Model.Lorry;

public class CustQueryVehicleView extends View {
	
	private JLabel welcomeCustomer, vehicleListing, car, bus, lorry;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private String username;
	private CustVehicleController controller;
	


	public CustQueryVehicleView(String username) {
		
		
		HireSystem system = new HireSystem();

		this.username = username;
		this.controller = new CustVehicleController(this.username);
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
	
		ArrayList<Car> carList = system.getAllCars();
		Object[][] cTable = new Object[carList.size()][];
		for(int i =0; i<carList.size();i++) {
			cTable[i] = new Object[] {
					carList.get(i).getVehicleRegNo(),
					carList.get(i).getVehicleModel(),
					carList.get(i).getVehicleMake(),
					carList.get(i).getVehicleTopSpeed(),
					carList.get(i).getVehicleDailyHireRate(),
					carList.get(i).getFuelType(),
					carList.get(i).getDoors()
			};
		}
		
		ArrayList<Bus> busList = system.getAllBus();
		Object[][] bTable = new Object[busList.size()][];
		for(int i =0; i<busList.size();i++) {
			bTable[i] = new Object[] {
					busList.get(i).getVehicleRegNo(),
					busList.get(i).getVehicleModel(),
					busList.get(i).getVehicleMake(),
					busList.get(i).getVehicleTopSpeed(),
					busList.get(i).getVehicleDailyHireRate(),
					busList.get(i).getMaxSeatCapacity()
			};
		}
		
		
		ArrayList<Lorry> lorryList = system.getAllLorry();
		Object[][] lTable = new Object[lorryList.size()][];
		for(int i =0; i<lorryList.size();i++) {
			lTable[i] = new Object[] {
					lorryList.get(i).getVehicleRegNo(),
					lorryList.get(i).getVehicleModel(),
					lorryList.get(i).getVehicleMake(),
					lorryList.get(i).getVehicleTopSpeed(),
					lorryList.get(i).getVehicleDailyHireRate(),
					lorryList.get(i).getMaxLoadCapacity()
			};
		}
		
		

		JTable carTable = new JTable(cTable,new String[] {"Reg. No.", "Model","Make","Top Speed", "Daily Hire Rate","Fuel Type","No. of Doors"});
		JTable busTable = new JTable(bTable,new String[] {"Reg. No.", "Model","Make","Top Speed", "Daily Hire Rate","Max. Seat Capacity"});
		JTable lorryTable = new JTable(lTable,new String[] {"Reg. No.", "Model","Make","Top Speed", "Daily Hire Rate","Max. Load Capacity"});
		
		JPanel mainPanel = new JPanel();
		JPanel carPanel = new JPanel();
		JPanel busPanel = new JPanel();
		JPanel lorryPanel = new JPanel();
		JPanel hirePanel = new JPanel();
		
		JPanel pTop = new JPanel();
		JPanel pLeft = new JPanel();
		JPanel pRight = new JPanel();
		JPanel pBot = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehicle Hire System");
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		mainPanel.setLayout(new GridLayout(0,1));
		carPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		carPanel.setLayout(new BorderLayout());
		busPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		busPanel.setLayout(new BorderLayout());
		lorryPanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		lorryPanel.setLayout(new BorderLayout());
		hirePanel.setBorder(BorderFactory.createEmptyBorder(20,20, 20, 20));
		hirePanel.setLayout(new BorderLayout());
		
		pLeft.setBorder(BorderFactory.createEmptyBorder(40,30, 20, 30));
		pRight.setBorder(BorderFactory.createEmptyBorder(40,30, 20, 30));
		
		pTop.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		pRight.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));
		pBot.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		pBot.setLayout(new GridLayout(0,1));
		pTop.setLayout(new GridLayout(0,4));
		
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
	
		
		car = new JLabel("Car Listing");
		carPanel.add(car,BorderLayout.NORTH);
		
		bus = new JLabel("Mini-Bus Listing");
		busPanel.add(bus,BorderLayout.NORTH);
		
		lorry = new JLabel("Lorry Listing");
		lorryPanel.add(lorry,BorderLayout.NORTH);
		
		carPanel.add(new JScrollPane(carTable),BorderLayout.CENTER);
		busPanel.add(new JScrollPane(busTable),BorderLayout.CENTER);
		lorryPanel.add(new JScrollPane(lorryTable),BorderLayout.CENTER);
		frame.add(pTop,BorderLayout.NORTH);
		mainPanel.add(carPanel);
		mainPanel.add(busPanel);
		mainPanel.add(lorryPanel);		
		frame.add(mainPanel,BorderLayout.CENTER);
		frame.add(pBot,BorderLayout.SOUTH);

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
