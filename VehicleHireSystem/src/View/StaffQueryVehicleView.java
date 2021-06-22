package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.QueryCustController;
import Controller.QueryVehicleController;
import Model.Bus;
import Model.Car;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Lorry;
import Model.Vehicle;

public class StaffQueryVehicleView extends View{

	private JLabel welcomeStaff,selectedVehRegNo, custId;
	protected JPanel hirePanel;
	private JTextField custIdText;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private JButton hireButton;
	private JLabel car,bus,lorry;
	private JButton addCarButton;
	private JButton addBusButton;
	private JButton addLorryButton;
	private JButton removeVehiclesBtn;
	private String vehRegNo;
	
	private QueryVehicleController controller = new QueryVehicleController();


	public StaffQueryVehicleView() {
		HireSystem system = new HireSystem();
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
		
		welcomeStaff = new JLabel("Welcome Staff");
		welcomeStaff.setBounds(10, 80, 80, 25);
		pTop.add(welcomeStaff);
		
		vehiclesButton = new JButton("Query Vehicles");
		vehiclesButton.setBounds(10, 80, 80, 25);
		vehiclesButton.addActionListener(this.controller);
		pTop.add(vehiclesButton);
		
		customersButton = new JButton("Query Customers");
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
		
		
		addCarButton = new JButton("Add New Cars");
		addCarButton.addActionListener(this.controller);
		carPanel.add(addCarButton,BorderLayout.EAST);
		
		addBusButton = new JButton("Add New Bus");
		addBusButton.addActionListener(this.controller);
		busPanel.add(addBusButton,BorderLayout.EAST);
		
		addLorryButton = new JButton("Add New Lorry");
		addLorryButton.addActionListener(this.controller);
		lorryPanel.add(addLorryButton,BorderLayout.EAST);
		

		custId = new JLabel("Customer Id: ");
		hirePanel.add(custId,BorderLayout.WEST);
		
		custIdText = new JTextField();
		hirePanel.add(custIdText,BorderLayout.CENTER);
		
		hireButton = new JButton("Hire Vehicle");
		hirePanel.add(hireButton,BorderLayout.EAST);
		
		
		removeVehiclesBtn = new JButton("Remove Vehicle");
		removeVehiclesBtn.setBounds(40, 80, 80, 25);
		removeVehiclesBtn.addActionListener(this.controller);
		removeVehiclesBtn.setVisible(false);
		pBot.add(hirePanel,BorderLayout.NORTH);
		pBot.add(removeVehiclesBtn,BorderLayout.SOUTH);
		

		
		carPanel.add(new JScrollPane(carTable),BorderLayout.CENTER);
		busPanel.add(new JScrollPane(busTable),BorderLayout.CENTER);
		lorryPanel.add(new JScrollPane(lorryTable),BorderLayout.CENTER);
		frame.add(pTop,BorderLayout.NORTH);
		mainPanel.add(carPanel);
		mainPanel.add(busPanel);
		mainPanel.add(lorryPanel);		

		hirePanel.setVisible(false);
				
		frame.add(mainPanel,BorderLayout.CENTER);
		frame.add(pBot,BorderLayout.SOUTH);

		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
		this.controller.addView(this);
		
		
		carTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {


			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				vehRegNo = carTable.getValueAt(carTable.getSelectedRow(), 0).toString();
				removeVehiclesBtn.setVisible(true);
				hirePanel.setVisible(true);

			}
			
		});
		
	}


	public String getDelVehRegNo() {
		return this.vehRegNo;
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
	public JButton getAddCarButton() {
		return this.addCarButton;
	}
	public JButton getRemoveVehicleBtn() {
		return this.removeVehiclesBtn;
	}
	
	public void setSuccessText(String text) {
		JOptionPane.showMessageDialog(null,text);	
	}
	
	
}
