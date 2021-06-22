package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.AddVehicleController;
import Model.HireSystem;

public class StaffAddBusView extends View {
	
	private JLabel welcomeStaff, successMessage;
	private JLabel bRegNoLabel, bMakeLabel, bModelLabel, bSpeedLabel, bSeatCapLabel, bRateLabel;
	private JTextField bRegNoText, bMakeText, bModelText, bSpeedText, bSeatCapText, bRateText;
	private JButton vehiclesButton, customersButton, logoutButton, saveButton;
	
	private HireSystem system = new HireSystem();
	private AddVehicleController controller = new AddVehicleController(system,"Bus");
	
	public StaffAddBusView() {
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
		
		bRegNoLabel = new JLabel("Registration No.");
		bRegNoLabel.setBounds(10, 20, 80, 25);
		panel.add(bRegNoLabel);
		
		bRegNoText = new JTextField(10);
		bRegNoText.setBounds(100, 20, 165, 25);
		panel.add(bRegNoText);
		
		bMakeLabel = new JLabel("Bus Make");
		bMakeLabel.setBounds(10, 50, 80, 25);
		panel.add(bMakeLabel);
		
		bMakeText = new JTextField(30);
		bMakeText.setBounds(100, 50, 165, 25);
		panel.add(bMakeText);
		
		bModelLabel = new JLabel("Bus Model");
		bModelLabel.setBounds(10, 80, 80, 25);
		panel.add(bModelLabel);
		
		bModelText = new JTextField(75);
		bModelText.setBounds(100, 80, 165, 25);
		panel.add(bModelText);
		
		bSpeedLabel = new JLabel("Bus Speed");
		bSpeedLabel.setBounds(10, 110, 80, 25);
		panel.add(bSpeedLabel);
		
		bSpeedText = new JTextField(13);
		bSpeedText.setBounds(100, 110, 165, 25);
		panel.add(bSpeedText);
		
		bRateLabel = new JLabel("Bus Daily Rate");
		bRateLabel.setBounds(10, 50, 140, 25);
		panel.add(bRateLabel);
		
		bRateText = new JTextField(40);
		bRateText.setBounds(100, 140, 165, 25);
		panel.add(bRateText);
		
		bSeatCapLabel = new JLabel("Bus Seat Capacity");
		bSeatCapLabel.setBounds(10, 170, 80, 25);
		panel.add(bSeatCapLabel);
		
		bSeatCapText = new JTextField(30);
		bSeatCapText.setBounds(100, 170, 165, 25);
		panel.add(bSeatCapText);
		
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
	    
	    this.controller.addBusView(this);
	    
		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
	}

	
	public String getbRegNoText() {
		return bRegNoText.getText();
	}

	public String getbMakeText() {
		return bMakeText.getText();
	}

	public String getbModelText() {
		return bModelText.getText();
	}

	public String getbSpeedText() {
		return bSpeedText.getText();
	}

	public String getbRateText() {
		return bRateText.getText();
	}
	
	public String getMaxCap() {
		return bSeatCapText.getText();
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
	
	public void setSuccessText(String text) {
		JOptionPane.showMessageDialog(null,text);	
	}
	
}

