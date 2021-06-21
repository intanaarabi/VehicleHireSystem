package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.HireSystem;

public class AddCustController implements ActionListener {
	
	private HireSystem system;


	public AddCustController(HireSystem system) {
		this.system = system;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//this.view.getCustomerName..etc
		//CorporateCustomer newCustomer = new CorporateCustomer(...);
		//this.system.addCustomer(newCustomer);
	}

	
}
