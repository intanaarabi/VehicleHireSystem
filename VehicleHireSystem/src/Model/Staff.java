package Model;

public class Staff extends User {
	
	public int staffId;

	public Staff(String username, String password, int staffId) {
		super(username, password);
		this.staffId = staffId;
	}

}
