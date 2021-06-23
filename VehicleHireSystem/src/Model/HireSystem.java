package Model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class HireSystem implements Serializable{

	private ArrayList<CorporateCustomer> allCustomers = new ArrayList<>();
	private ArrayList<Car> allCars = new ArrayList<>();
	private ArrayList<Bus> allBus = new ArrayList<>();
	private ArrayList<Lorry> allLorry = new ArrayList<>();
	private ArrayList<Vehicle> allVehicles = new ArrayList<>();
	
	public HireSystem() {
		this.setCustomers();
		this.setCar();
		this.setBus();
		this.setLorry();
		this.setVehicles();
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
	
	public Boolean checkCustExist(String custId) {
		for (int i = 0; i<allCustomers.size();i++) {
			if (allCustomers.get(i).getCustomerId().equals(custId)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean checkVehicleExist(String vehRegNo) {
		for (int i = 0; i<allVehicles.size();i++) {
			if (allVehicles.get(i).getVehicleRegNo().equals(vehRegNo)) {
				return true;
			}
		}
		return false;
	}
	
	public CorporateCustomer getCustomer(String custId) {
		for (int i = 0; i<allCustomers.size();i++) {
			if (allCustomers.get(i).getCustomerId().equals(custId)) {
				return allCustomers.get(i);
			}
		}
		return null;
	};
	
	
	public CorporateCustomer getCustomerUser(String userName) {
		for (int i = 0; i<allCustomers.size();i++) {
			if (allCustomers.get(i).getUsername().equals(userName)) {
				return allCustomers.get(i);
			}
		}
		return null;
	};
	
	public Vehicle getVehicle(String vehId) {
		for (int i = 0; i<allVehicles.size();i++) {
			if (allVehicles.get(i).getVehicleRegNo().equals(vehId)) {
				if(allVehicles.get(i) instanceof Car) {
					return (Car) allVehicles.get(i);
				} else if (allVehicles.get(i) instanceof Bus) {
					return (Bus) allVehicles.get(i);
				} else {
					return (Lorry) allVehicles.get(i);
				}
			}
		}
		return null;
	};
	
	public void updateCustomer(CorporateCustomer customer) {
		for (int i = 0; i<allCustomers.size();i++) {
			if (allCustomers.get(i).getCustomerId().equals(customer.getCustomerId())) {
				allCustomers.remove(allCustomers.get(i));
			}
		}
		
		allCustomers.add(customer);
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("src/customer.dat",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i=0;i<this.allCustomers.size();i++) {
				oos.writeObject(this.allCustomers.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Boolean addCustomer(CorporateCustomer customer) {
		try {
			if (!checkCustExist(customer.getCustomerId())) {
				allCustomers.add(customer);
			} else {
				return false;
			}
			
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
		return true;
	};
	
	public Boolean addCar(Car vehicle) {

		try {
			if (!checkVehicleExist(vehicle.getVehicleRegNo())) {
				allCars.add(vehicle);
				allVehicles.add(vehicle);
			} else {
				return false;
			}
			
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
		
		return true;
	}
	
	
	public Boolean addBus(Bus vehicle) {

		try {
			if (!checkVehicleExist(vehicle.getVehicleRegNo())) {
				allBus.add(vehicle);
				allVehicles.add(vehicle);
			} else {
				return false;
			}
			
			File file = new File("src/bus.dat");
			ObjectOutputStream voos;

			FileOutputStream vfos = new FileOutputStream("src/bus.dat",true);
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
		
		return true;
	}
	
	public Boolean addLorry(Lorry vehicle) {

		try {
			if (!checkVehicleExist(vehicle.getVehicleRegNo())) {
				allLorry.add(vehicle);
				allVehicles.add(vehicle);
			} else {
				return false;
			}
			
			File file = new File("src/lorry.dat");
			ObjectOutputStream voos;

			FileOutputStream vfos = new FileOutputStream("src/lorry.dat",true);
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
		
		return true;
	}
	
	
	public void removeVehicle(String vehicleRegNo) {
		
		String vType = null;
		
		for (int i = 0;i<allVehicles.size();i++) {
			if(allVehicles.get(i).getVehicleRegNo().equals(vehicleRegNo)) {
				if (allVehicles.get(i) instanceof Car) {
					vType = "Car";
					this.allCars.remove(allVehicles.get(i));
				} else if (allVehicles.get(i) instanceof Bus) {
					vType = "Bus";
					this.allBus.remove(allVehicles.get(i));
				} else {
					vType = "Lorry";
					this.allLorry.remove(allVehicles.get(i));
				}
				this.allVehicles.remove(allVehicles.get(i));
			}
		}
		
	
		try {
			if (vType.equals("Car")) {
				FileOutputStream fos = new FileOutputStream("src/car.dat",false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (int i=0;i<this.allCars.size();i++) {
					oos.writeObject(this.allCars.get(i));
				}
			} else if (vType.equals("Bus")) {
				FileOutputStream fos = new FileOutputStream("src/bus.dat",false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (int i=0;i<this.allBus.size();i++) {
					oos.writeObject(this.allBus.get(i));
				}
			} else {
				FileOutputStream fos = new FileOutputStream("src/lorry.dat",false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (int i=0;i<this.allLorry.size();i++) {
					oos.writeObject(this.allLorry.get(i));
				}
	
				oos.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
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
	
	public void setVehicles() {
		for (int i = 0; i<this.allCars.size();i++) {
			allVehicles.add((Car) this.allCars.get(i));
		}
		for (int i = 0; i<this.allBus.size();i++) {
			allVehicles.add((Bus) this.allBus.get(i));
		}
		for (int i = 0; i<this.allLorry.size();i++) {
			allVehicles.add((Lorry) this.allLorry.get(i));
		}
	}

}
