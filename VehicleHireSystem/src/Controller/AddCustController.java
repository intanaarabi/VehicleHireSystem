package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CorporateCustomer;
import Model.HireSystem;
import View.LoginView;
import View.StaffAddCustomerView;
import View.StaffQueryCustomerView;
import View.View;

public class AddCustController implements ActionListener {
	
	private HireSystem system;
	private StaffAddCustomerView view;


	public AddCustController(HireSystem system) {
		this.system = system;
	}
	
	public void addView(StaffAddCustomerView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.view.getSaveButton())) {
			String customerId = this.view.getCustomerId();
			String customerName = this.view.getCustomerName();
			String customerAddr = this.view.getCustomerAddress();
			String customerPhoneNum = this.view.getCustomerPhoneNum();
			String customerEmail = this.view.getCustomerEmail();
			String customerUsername = this.view.getCustomerUsername();
			String customerPassword = this.view.getCustomerPassword();
			CorporateCustomer newCustomer = new CorporateCustomer(customerUsername,customerPassword,customerId,customerName,customerAddr,customerPhoneNum,customerEmail);
			this.system.addCustomer(newCustomer);
			
		} else if (e.getSource().equals(this.view.getCustomersButton())) {
			StaffQueryCustomerView newView = new StaffQueryCustomerView();
			this.view.setNextView(newView);
		}
	}

	
}
