package View;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StaffCustomerView {
	
	private JPanel panel;

	private JLabel cIdLabel;
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
	private JButton deleteButton;
	

	private Object controller;
	

	public StaffCustomerView() {
		JPanel panel = new JPanel();
		
		this.controller = controller;
		
		panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		panel.setLayout(new GridLayout(0,1));
		
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
		
		vehiclesButton = new JButton("Vehicles");
		vehiclesButton.setBounds(null);
		vehiclesButton.addActionListener(null);
		panel.add(vehiclesButton);
		
		customersButton = new JButton("Customers");
		customersButton.setBounds(null);
		customersButton.addActionListener(null);
		panel.add(customersButton);
		
		logoutButton = new JButton("logout");
		logoutButton.setBounds(null);
		logoutButton.addActionListener(null);
		panel.add(logoutButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(null);
		saveButton.addActionListener(null);
		panel.add(saveButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(null);
		deleteButton.addActionListener(null);
		panel.add(deleteButton);
		
		
		
		
		this.panel = panel;
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
	public JButton getDeleteButton() {
		return this.deleteButton;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	

}
