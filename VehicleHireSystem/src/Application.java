import java.io.*;

import Model.Login;
import Model.Staff;

public class Application {
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("src/staff.dat",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Staff staff = new Staff("Admin","Admin",1);
			oos.writeObject(staff);
			oos.close();
			
			Login value = new Login("Admin","Admin");
			Boolean auth = value.authStaff();
			System.out.println(auth);

			
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			System.out.println("End of file reached."); 
		}		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
