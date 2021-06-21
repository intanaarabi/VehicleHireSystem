
import java.awt.BorderLayout;
import java.io.*;

import javax.swing.JFrame;

import Controller.LoginController;
import Model.HireSystem;
import Model.Login;
import Model.Staff;
import View.LoginView;


public class Application {
	
	private static JFrame frame;
	private static HireSystem system;
	
	public static void main(String[] args) {
	
		system = new HireSystem();
		system.setCustomers();
		system.setVehicles();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			FileOutputStream sfos = new FileOutputStream("src/staff.dat",false);
			FileOutputStream cfos = new FileOutputStream("src/customer.dat",true);
			FileOutputStream vfos = new FileOutputStream("src/vehicle.dat",true);
			ObjectOutputStream oos = new ObjectOutputStream(sfos);
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
		
		Login login = new Login();
		LoginController loginController = new LoginController(login,frame);
		LoginView loginView = new LoginView(loginController);
		frame.setTitle("Login");
	    frame.add(loginView.getPanel(), BorderLayout.CENTER);
	   
	    
	    
	    
	    
	    
	    frame.pack();
	    frame.setVisible(true);
	}
	

}
