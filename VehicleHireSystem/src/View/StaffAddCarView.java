package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.AddVehicleController;
import Model.HireSystem;

public class StaffAddCarView extends View {
	
	
	private JLabel cRegNoLabel, welcomeStaff,successMessage;
	private JTextField cRegNoText;
	private JLabel cMakeLabel;
	private JTextField cMakeText;
	private JLabel cModelLabel;
	private JTextField cModelText;
	private JLabel cSpeedLabel;
	private JTextField cSpeedText;
	private JLabel cRateLabel;
	private JTextField cRateText;
	private JLabel cFuelTypeLabel;
	private JTextField cFuelTypeText;
	private JLabel cDoorsLabel;
	private JTextField cDoorsText;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private JButton saveButton;

	private HireSystem system = new HireSystem();
	private AddVehicleController controller = new AddVehicleController(system,"Car");

	public StaffAddCarView() {
		JPanel panel = new JPanel();
		JPanel pTop = new JPanel();
		JPanel pLeft = new JPanel();
		JPanel pRight = new JPanel();
		JPanel pBot = new JPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehicle Hire System");
		

		panel.setBorder(BorderFactory.createEmptyBorder(20,50, 20, 50));
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.WHITE);
		
		
		pLeft.setBorder(BorderFactory.createEmptyBorder(40,30, 20, 30));
		pRight.setBorder(BorderFactory.createEmptyBorder(40,30, 20, 30));
		
		pTop.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		pBot.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		pTop.setLayout(new GridLayout(0,4));
		
		cRegNoLabel = new JLabel("Registration No.");
		cRegNoLabel.setBounds(10, 20, 80, 25);
		panel.add(cRegNoLabel);
		
		cRegNoText = new JTextField(10);
		cRegNoText.setBounds(100, 20, 165, 25);
		panel.add(cRegNoText);
		
		cMakeLabel = new JLabel("Car Make");
		cMakeLabel.setBounds(10, 50, 80, 25);
		panel.add(cMakeLabel);
		
		cMakeText = new JTextField(30);
		cMakeText.setBounds(100, 50, 165, 25);
		panel.add(cMakeText);
		
		cModelLabel = new JLabel("Car Model");
		cModelLabel.setBounds(10, 80, 80, 25);
		panel.add(cModelLabel);
		
		cModelText = new JTextField(75);
		cModelText.setBounds(100, 80, 165, 25);
		panel.add(cModelText);
		
		cSpeedLabel = new JLabel("Car Speed");
		cSpeedLabel.setBounds(10, 110, 80, 25);
		panel.add(cSpeedLabel);
		
		cSpeedText = new JTextField(13);
		cSpeedText.setBounds(100, 110, 165, 25);
		panel.add(cSpeedText);
		
		cRateLabel = new JLabel("Car Daily Rate");
		cRateLabel.setBounds(10, 50, 140, 25);
		panel.add(cRateLabel);
		
		cRateText = new JTextField(40);
		cRateText.setBounds(100, 140, 165, 25);
		panel.add(cRateText);
		
		cFuelTypeLabel = new JLabel("Car Fuel Type");
		cFuelTypeLabel.setBounds(10, 170, 80, 25);
		panel.add(cFuelTypeLabel);
		
		cFuelTypeText = new JTextField(30);
		cFuelTypeText.setBounds(100, 170, 165, 25);
		panel.add(cFuelTypeText);
		
		cDoorsLabel = new JLabel("Car Num. Doors");
		cDoorsLabel.setBounds(10, 200, 80, 25);
		panel.add(cDoorsLabel);
		
		cDoorsText = new JTextField(25);
		cDoorsText.setBounds(100, 200, 165, 25);
		panel.add(cDoorsText);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(100, 80, 165, 25);
		saveButton.addActionListener(this.controller);
		panel.add(saveButton);
		
		successMessage = new JLabel("");
		successMessage.setBounds(100, 200, 165, 25);
		panel.add(successMessage);
		
		
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
		
	
		this.panel = panel;

		frame.add(pTop,BorderLayout.NORTH);
	    frame.add(panel,BorderLayout.CENTER);
	    frame.add(pLeft,BorderLayout.WEST);
	    frame.add(pRight,BorderLayout.EAST);
	    frame.add(pBot,BorderLayout.SOUTH);
	    
	    this.controller.addCarView(this);
	    
		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
	}
	
	public String getcRegNoText() {
		return cRegNoText.getText();
	}

	public String getcMakeText() {
		return cMakeText.getText();
	}

	public String getcModelText() {
		return cModelText.getText();
	}

	public String getcSpeedText() {
		return cSpeedText.getText();
	}

	public String getcRateText() {
		return cRateText.getText();
	}

	public String getcFuelTypeText() {
		return cFuelTypeText.getText();
	}

	public String getcDoorsText() {
		return cDoorsText.getText();
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
	public JButton getSaveButton() {
		return this.saveButton;
	}
	
	public void setSuccessText() {
		this.successMessage.setText("New Car Added Successfully");
	}
	
	public void setFailText() {
		this.successMessage.setText("Failed to add new Car.");
	}

}
