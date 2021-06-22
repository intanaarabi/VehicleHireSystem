package Model;

import java.io.Serializable;

public class Lorry extends Vehicle implements Serializable{
	
	private int maxLoadCapacity;

	public Lorry(String vehicleMake, String vehicleModel, int vehicleTopSpeed, String vehicleRegNo,
			int vehicleDailyHireRate, int maxLoadCapacity) {
		super(vehicleMake, vehicleModel, vehicleTopSpeed, vehicleRegNo, vehicleDailyHireRate);
		this.maxLoadCapacity = maxLoadCapacity;
	}
	
	public int getMaxLoadCapacity() {
		return this.maxLoadCapacity;
	}

}
