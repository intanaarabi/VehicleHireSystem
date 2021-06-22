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

public class StaffAddLorryView extends View {

		
		private JLabel welcomeStaff, successMessage;
		private JLabel lRegNoLabel, lMakeLabel, lModelLabel, lSpeedLabel, lLoadCapLabel, lRateLabel;
		private JTextField lRegNoText, lMakeText, lModelText, lSpeedText, lLoadCapText, lRateText;
		private JButton vehiclesButton, customersButton, logoutButton, saveButton;
		
		private HireSystem system = new HireSystem();
		private AddVehicleController controller = new AddVehicleController(system,"Lorry");
		
		public StaffAddLorryView() {
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
			
			lRegNoLabel = new JLabel("Registration No.");
			lRegNoLabel.setBounds(10, 20, 80, 25);
			panel.add(lRegNoLabel);
			
			lRegNoText = new JTextField(10);
			lRegNoText.setBounds(100, 20, 165, 25);
			panel.add(lRegNoText);
			
			lMakeLabel = new JLabel("Lorry Make");
			lMakeLabel.setBounds(10, 50, 80, 25);
			panel.add(lMakeLabel);
			
			lMakeText = new JTextField(30);
			lMakeText.setBounds(100, 50, 165, 25);
			panel.add(lMakeText);
			
			lModelLabel = new JLabel("Lorry Model");
			lModelLabel.setBounds(10, 80, 80, 25);
			panel.add(lModelLabel);
			
			lModelText = new JTextField(75);
			lModelText.setBounds(100, 80, 165, 25);
			panel.add(lModelText);
			
			lSpeedLabel = new JLabel("Lorry Speed");
			lSpeedLabel.setBounds(10, 110, 80, 25);
			panel.add(lSpeedLabel);
			
			lSpeedText = new JTextField(13);
			lSpeedText.setBounds(100, 110, 165, 25);
			panel.add(lSpeedText);
			
			lRateLabel = new JLabel("Lorry Daily Rate");
			lRateLabel.setBounds(10, 50, 140, 25);
			panel.add(lRateLabel);
			
			lRateText = new JTextField(40);
			lRateText.setBounds(100, 140, 165, 25);
			panel.add(lRateText);
			
			lLoadCapLabel = new JLabel("Lorry Load Capacity");
			lLoadCapLabel.setBounds(10, 170, 80, 25);
			panel.add(lLoadCapLabel);
			
			lLoadCapText = new JTextField(30);
			lLoadCapText.setBounds(100, 170, 165, 25);
			panel.add(lLoadCapText);
			
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
		    
		    this.controller.addLorryView(this);
		    
			this.frame = frame;
			this.frame.pack();
			this.frame.setSize(700,700);
			this.frame.setVisible(true);
		}
		
		public String getlRegNoText() {
			return lRegNoText.getText();
		}

		public String getlMakeText() {
			return lMakeText.getText();
		}

		public String getlModelText() {
			return lModelText.getText();
		}

		public String getlSpeedText() {
			return lSpeedText.getText();
		}

		public String getlRateText() {
			return lRateText.getText();
		}

		public String getMaxWeight() {
			return lLoadCapText.getText();
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