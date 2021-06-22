package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.QueryCustController;
import Controller.QueryVehicleController;
import Model.Car;
import Model.CorporateCustomer;
import Model.HireSystem;
import Model.Vehicle;

public class StaffQueryVehicleView extends View{

	private JLabel welcomeStaff;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private JButton addCarButton;
	private JButton addBusButton;
	private JButton addLorryButton;
	private JButton removeVehiclesBtn;
	
	private QueryVehicleController controller = new QueryVehicleController();
	

	public StaffQueryVehicleView() {
		HireSystem system = new HireSystem();
		JFrame frame = new JFrame();

	
		ArrayList<Car> carList = system.getAllCars();
		Object[][] table = new Object[carList.size()][];
		for(int i =0; i<carList.size();i++) {
			table[i] = new Object[] {
					carList.get(i).getVehicleRegNo(),
					carList.get(i).getVehicleModel(),
					carList.get(i).getVehicleMake(),
					carList.get(i).getVehicleTopSpeed(),
					carList.get(i).getVehicleDailyHireRate(),
					carList.get(i).getFuelType(),
					carList.get(i).getDoors()
			};
		}
		
		JTable carTable = new JTable(table,new String[] {"Reg. No.", "Model","Make","Top Speed", "Daily Hire Rate","Fuel Type","No. of Doors"});
		
		JPanel panel = new JPanel();
		JPanel pTop = new JPanel();
		JPanel pLeft = new JPanel();
		JPanel pRight = new JPanel();
		JPanel pBot = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehicle Hire System");
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(20,50, 20, 50));
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.WHITE);
		
		
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
		
		addCarButton = new JButton("Add New Cars");
		addCarButton.addActionListener(this.controller);
		pRight.add(addCarButton);
		
		removeVehiclesBtn = new JButton("Remove Vehicle");
		removeVehiclesBtn.setBounds(40, 80, 80, 25);
		removeVehiclesBtn.addActionListener(this.controller);
		removeVehiclesBtn.setVisible(false);
		pBot.add(removeVehiclesBtn);
		
		frame.add(pTop,BorderLayout.NORTH);
		frame.add(pBot,BorderLayout.AFTER_LAST_LINE);
		frame.add(pRight,BorderLayout.EAST);
		frame.add(new JScrollPane(carTable));
		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
		this.controller.addView(this);
		
		
		carTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				removeVehiclesBtn.setVisible(true);
			}
			
		});
		
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
	
}
