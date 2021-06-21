package Model;

import java.io.Serializable;

public class Staff extends User implements Serializable{
	
	public int staffId;

	public Staff(String username, String password, int staffId) {
		super(username, password);
		this.staffId = staffId;
	}

}
