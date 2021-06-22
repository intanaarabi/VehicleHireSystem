package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CorporateCustomer extends User implements Serializable{
	
	private String customerId;
	private String customerCorpName;
	private String customerAddr;
	private String customerPhoneNo;
	private String customerEmail;
	private ArrayList <Vehicle> hiredVehicles = new ArrayList <>();

	public CorporateCustomer(String username, String password, String customerId, String customerCorpName, String customerAddr, String customerPhoneNo, String customerEmail) {
		super(username, password);
		this.customerId = customerId;
		this.customerCorpName = customerCorpName;
		this.customerAddr = customerAddr;
		this.customerPhoneNo = customerPhoneNo;
		this.customerEmail = customerEmail;
	}
	
	
	public ArrayList<Vehicle> getHiredVehicles(){
		return this.hiredVehicles;
	}
	
	public Vehicle getVehicle(String vehRegNo) {
		for (int i = 0;i<hiredVehicles.size();i++) {
			if (hiredVehicles.get(i).getVehicleRegNo().equals(vehRegNo)) {
				if (hiredVehicles.get(i) instanceof Car) {
					return (Car) hiredVehicles.get(i);
				} else if  (hiredVehicles.get(i) instanceof Bus) {
					return (Bus) hiredVehicles.get(i);
				} else 
					return (Lorry) hiredVehicles.get(i);
			}
		}
		return null;
	}
	
	public void addVehicle(Vehicle vehicle) {
		hiredVehicles.add(vehicle);	
	}
	
	public void returnVehicle(Vehicle vehicle) {
		hiredVehicles.remove(vehicle);
	}
	
	
	
	public String getCustomerId() {
		return this.customerId;
	}
	
	public String getCustomerCorpName() {
		return this.customerCorpName;
	}
	
	public String getCustomerAddr() {
		return this.customerAddr;
	}
	
	public String getCustomerPhoneNo() {
		return this.customerPhoneNo;
	}
	
	public String getCustomerEmail() {
		return this.customerEmail;
	}

}
