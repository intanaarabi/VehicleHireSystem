package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.AddCustController;
import Model.HireSystem;

public class StaffAddCustomerView extends View {


	private JLabel cIdLabel, welcomeStaff, successMessage, failMessage;
	private JTextField cIdText;
	private JLabel cNameLabel;
	private JTextField cNameText;
	private JLabel cAddressLabel;
	private JTextField cAddressText;
	private JLabel cPhNumberLabel;
	private JTextField cPhNumberText;
	private JLabel cEmailLabel;
	private JTextField cEmailText;
	private JLabel cUsernameLabel;
	private JTextField cUsernameText;
	private JLabel cPasswordLabel;
	private JTextField cPasswordText;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private JButton saveButton;


	private HireSystem system = new HireSystem();
	private AddCustController controller = new AddCustController(system);
	

	public StaffAddCustomerView() {
		
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
		
		cIdLabel = new JLabel("Customer Id");
		cIdLabel.setBounds(10, 20, 80, 25);
		panel.add(cIdLabel);
		
		cIdText = new JTextField(10);
		cIdText.setBounds(100, 20, 165, 25);
		panel.add(cIdText);
		
		cNameLabel = new JLabel("Customer Name");
		cNameLabel.setBounds(10, 50, 80, 25);
		panel.add(cNameLabel);
		
		cNameText = new JTextField(30);
		cNameText.setBounds(100, 50, 165, 25);
		panel.add(cNameText);
		
		cAddressLabel = new JLabel("Customer Address");
		cAddressLabel.setBounds(10, 80, 80, 25);
		panel.add(cAddressLabel);
		
		cAddressText = new JTextField(75);
		cAddressText.setBounds(100, 80, 165, 25);
		panel.add(cAddressText);
		
		cPhNumberLabel = new JLabel("Customer Phone Number");
		cPhNumberLabel.setBounds(10, 110, 80, 25);
		panel.add(cPhNumberLabel);
		
		cPhNumberText = new JTextField(13);
		cPhNumberText.setBounds(100, 110, 165, 25);
		panel.add(cPhNumberText);
		
		cEmailLabel = new JLabel("Customer Email");
		cEmailLabel.setBounds(10, 50, 140, 25);
		panel.add(cEmailLabel);
		
		cEmailText = new JTextField(40);
		cEmailText.setBounds(100, 140, 165, 25);
		panel.add(cEmailText);
		
		cUsernameLabel = new JLabel("Customer Username");
		cUsernameLabel.setBounds(10, 170, 80, 25);
		panel.add(cUsernameLabel);
		
		cUsernameText = new JTextField(30);
		cUsernameText.setBounds(100, 170, 165, 25);
		panel.add(cUsernameText);
		
		cPasswordLabel = new JLabel("Customer Password");
		cPasswordLabel.setBounds(10, 200, 80, 25);
		panel.add(cPasswordLabel);
		
		cPasswordText = new JTextField(25);
		cPasswordText.setBounds(100, 200, 165, 25);
		panel.add(cPasswordText);
		
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
	    
	    this.controller.addView(this);
	    
		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
	}
	
	public String getCustomerId() {
		return this.cIdText.getText();
	}
	public String getCustomerName() {
		return this.cNameText.getText();
	}
	public String getCustomerAddress() {
		return this.cAddressText.getText();
	}
	public String getCustomerPhoneNum() {
		return this.cPhNumberText.getText();
	}
	public String getCustomerEmail() {
		return this.cEmailText.getText();
	}
	public String getCustomerUsername() {
		return this.cUsernameText.getText();
	}
	public String getCustomerPassword() {
		return this.cPasswordText.getText();
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
		this.successMessage.setText("New Customer Added Successfully");
	}
	
	public void setFailText() {
		this.successMessage.setText("Failed to add new customer.");
	}
	

}
