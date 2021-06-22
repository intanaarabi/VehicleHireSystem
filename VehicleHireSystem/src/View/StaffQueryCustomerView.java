package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Controller.AddCustController;
import Controller.QueryCustController;
import Model.CorporateCustomer;
import Model.HireSystem;

public class StaffQueryCustomerView extends View {
	
	private JLabel welcomeStaff;
	private JButton vehiclesButton;
	private JButton customersButton;
	private JButton logoutButton;
	private JButton addCustButton;
	private JButton hiredVehiclesBtn;
	
	private QueryCustController controller = new QueryCustController();

	public StaffQueryCustomerView() {
		
		
		HireSystem system = new HireSystem();
		JFrame frame = new JFrame();

	
		ArrayList<CorporateCustomer> custList = system.getAllCustomers();
		Object[][] table = new Object[custList.size()][];
		for(int i =0; i<custList.size();i++) {
			table[i] = new Object[] {
					custList.get(i).getCustomerId(),
					custList.get(i).getCustomerCorpName(),
					custList.get(i).getCustomerAddr(),
					custList.get(i).getCustomerPhoneNo(),
					custList.get(i).getCustomerEmail()
			};
		}
		
		JTable custTable = new JTable(table,new String[] {"Cust. ID", "Cust. Name","Cust. Addr","Cust. Phone", "Cust. Email"});
		
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
		
		addCustButton = new JButton("Add New Customers");
		addCustButton.addActionListener(this.controller);
		pRight.add(addCustButton);
		
		hiredVehiclesBtn = new JButton("View Hired Vehicles");
		hiredVehiclesBtn.setBounds(40, 80, 80, 25);
		hiredVehiclesBtn.addActionListener(this.controller);
		hiredVehiclesBtn.setVisible(false);
		pBot.add(hiredVehiclesBtn);
		
		frame.add(pTop,BorderLayout.NORTH);
		frame.add(pBot,BorderLayout.AFTER_LAST_LINE);
		frame.add(pRight,BorderLayout.EAST);
		frame.add(new JScrollPane(custTable));
		this.frame = frame;
		this.frame.pack();
		this.frame.setSize(700,700);
		this.frame.setVisible(true);
		this.controller.addView(this);
		
		
		custTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				hiredVehiclesBtn.setVisible(true);
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
	public JButton getAddCustButton() {
		return this.addCustButton;
	}
	
	

}
