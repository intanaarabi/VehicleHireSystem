
import java.awt.BorderLayout;
import java.io.*;

import javax.swing.JFrame;

import Controller.LoginController;
import Model.Login;
import Model.Staff;
import View.LoginView;


public class Application {
	
	public static void main(String[] args) {
	
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		
		Login login = new Login();
		LoginController loginController = new LoginController(login);
		LoginView loginView = new LoginView(loginController);
		frame.setTitle("Login");
	    frame.add(loginView.getPanel(), BorderLayout.CENTER);
	   
	    
	    
	    
	    
	    
	    frame.pack();
	    frame.setVisible(true);
		
		
		
	}
	

}
