package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {

	
	public Boolean authStaff(String username, String password) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/staff.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Staff staff = null;
			
			while ((staff=(Staff)ois.readObject())!=null) { 
				if (staff.getUsername().equals(username) && staff.getPassword().equals(password)){
					ois.close();
					return true;
				}
			}
			
			ois.close();
		
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			return false;
		}	 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Boolean authCustomer(String username, String password) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/customer.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			CorporateCustomer customer = null;
			
			while ((customer=(CorporateCustomer)ois.readObject())!=null) { 
				if (customer.getUsername().equals(username) && customer.getPassword().equals(password)){
					ois.close();
					return true;
				}
			}
			
			ois.close();
		
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			return false;
		}	 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
