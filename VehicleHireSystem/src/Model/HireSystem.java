package Model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HireSystem {

	private ArrayList<CorporateCustomer> allCustomers = new ArrayList<>();
	private ArrayList<Car> allCars = new ArrayList<>();
	private ArrayList<Bus> allBus = new ArrayList<>();
	private ArrayList<Lorry> allLorry = new ArrayList<>();
	
	public HireSystem() {
		this.setCustomers();
		this.setCar();
		this.setBus();
		this.setLorry();
	}
	
	public ArrayList<CorporateCustomer> getAllCustomers(){
		return this.allCustomers;
	}
	

	public ArrayList<Car> getAllCars(){
		return this.allCars;
	}
	public ArrayList<Bus> getAllBus(){
		return this.allBus;
	}
	public ArrayList<Lorry> getAllLorry(){
		return this.allLorry;
	}
	
	public void addCustomer(CorporateCustomer customer) {
		allCustomers.add(customer);
		try {
			File file = new File("src/customer.dat");
			ObjectOutputStream coos;
			
			FileOutputStream cfos = new FileOutputStream("src/customer.dat",true);
			if(file.length() != 0) {
				coos = new MyObjectOutputStream(cfos);
			} else {
				coos = new ObjectOutputStream(cfos);
			}
 
			coos.writeObject(customer);
			coos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void addCar(Car vehicle) {
		allCars.add(vehicle);
		try {
			File file = new File("src/car.dat");
			ObjectOutputStream voos;

			FileOutputStream vfos = new FileOutputStream("src/car.dat",true);
			if(file.length() != 0) {
				voos = new MyObjectOutputStream(vfos);
			} else {
				voos = new ObjectOutputStream(vfos);
			}
			
			voos.writeObject(vehicle);
			voos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void removeVehicle(Vehicle vehicle) {
//		this.allVehicles.remove(vehicle);
//		try {
//			FileOutputStream vfos = new FileOutputStream("src/vehicle.dat",false);
//			ObjectOutputStream voos = new ObjectOutputStream(vfos);
//			for (int i=0;i<this.allVehicles.size();i++) {
//				voos.writeObject(this.allVehicles.get(i));
//			}
//			voos.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
//	}

	
	public void setCustomers() {
		FileInputStream fis;
		try {
			File file = new File("src/customer.dat");
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
			return;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setCar() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/car.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Car vehicle = null;
			
			while ((vehicle=(Car)ois.readObject())!=null) { 
				allCars.add(vehicle);
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
	
	public void setBus() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/bus.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Bus vehicle = null;
			
			while ((vehicle=(Bus)ois.readObject())!=null) { 
				allBus.add(vehicle);
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
	
	public void setLorry() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/lorry.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Lorry vehicle = null;
			
			while ((vehicle=(Lorry)ois.readObject())!=null) { 
				allLorry.add(vehicle);
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
