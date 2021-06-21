package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
	
	private String username;
	private String password;
	
	public Login(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public Boolean authStaff() {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/staff.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Staff staff = null;
			
			while ((staff=(Staff)ois.readObject())!=null) { 
				if (staff.getUsername().equals(this.username) && staff.getPassword().equals(this.password)){
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
