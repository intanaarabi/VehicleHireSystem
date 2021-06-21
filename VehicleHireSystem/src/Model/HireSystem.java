package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HireSystem {

	private ArrayList<CorporateCustomer> allCustomers = new ArrayList<>();
	private ArrayList<Vehicle> allVehicles = new ArrayList<>();
	
	public ArrayList<CorporateCustomer> getAllCustomers(){
		return this.allCustomers;
	}
	
	public ArrayList<Vehicle> getAllVehicles(){
		return this.allVehicles;
	}
	
	public void addCustomer(CorporateCustomer customer) {
		allCustomers.add(customer);
		try {
			FileOutputStream cfos = new FileOutputStream("src/customer.dat",true);
			ObjectOutputStream coos = new ObjectOutputStream(cfos);
			coos.writeObject(customer);
			coos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void addVehicle(Vehicle vehicle) {
		allVehicles.add(vehicle);
		try {
			FileOutputStream vfos = new FileOutputStream("src/vehicle.dat",true);
			ObjectOutputStream voos = new ObjectOutputStream(vfos);
			voos.writeObject(vehicle);
			voos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeVehicle(Vehicle vehicle) {
		this.allVehicles.remove(vehicle);
		try {
			FileOutputStream vfos = new FileOutputStream("src/vehicle.dat",false);
			ObjectOutputStream voos = new ObjectOutputStream(vfos);
			for (int i=0;i<this.allVehicles.size();i++) {
				voos.writeObject(this.allVehicles.get(i));
			}
			voos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	public void setCustomers() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/customer.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			CorporateCustomer customer = null;
			
			while ((customer=(CorporateCustomer)ois.readObject())!=null) { 
				allCustomers.add(customer);
			}
			ois.close();
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			return;
		}	 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setVehicles() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/vehicle.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Vehicle vehicle = null;
			
			while ((vehicle=(Vehicle)ois.readObject())!=null) { 
				allVehicles.add(vehicle);
			}
			ois.close();
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			return;
		}	 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
