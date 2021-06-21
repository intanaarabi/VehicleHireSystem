
import java.io.*;

import Controller.LoginController;
import Model.Login;
import Model.Staff;
import View.LoginView;


public class Application {
	
	public static void main(String[] args) {
	
		
		Login login = new Login();
		LoginController loginController = new LoginController(login);
		
		LoginView loginView = new LoginView(loginController);

		try {
			FileOutputStream fos = new FileOutputStream("src/staff.dat",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Staff staff = new Staff("Admin","Admin",1);
			oos.writeObject(staff);
			oos.close();
			
		
			
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
			System.out.println("End of file reached."); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}
	

}
