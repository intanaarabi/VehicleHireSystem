package Model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
	
	private String fuelType;
	private int doors;

	public Car(String vehicleMake, String vehicleModel, int vehicleTopSpeed, String vehicleRegNo,
			int vehicleDailyHireRate, String fuelType, int doors) {
		super(vehicleMake, vehicleModel, vehicleTopSpeed, vehicleRegNo, vehicleDailyHireRate);
		this.fuelType = fuelType;
		this.doors = doors;
	}
	
	public String getFuelType() {
		return this.fuelType;
	}
	
	public int getDoors() {
		return this.doors;
	}

}
