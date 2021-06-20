package Model;

public class Bus extends Vehicle {
	
	private int maxSeatCapacity;

	public Bus(String vehicleMake, String vehicleModel, int vehicleTopSpeed, String vehicleRegNo,
			int vehicleDailyHireRate, int maxSeatCapacity) {
		super(vehicleMake, vehicleModel, vehicleTopSpeed, vehicleRegNo, vehicleDailyHireRate);
		this.maxSeatCapacity = maxSeatCapacity;
	}
	
	public int getMaxSeatCapacity() {
		return this.maxSeatCapacity;
	}

}
