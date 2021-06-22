package Model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable{
	
	private String vehicleMake;
	private String vehicleModel;
	private int vehicleTopSpeed;
	private String vehicleRegNo;
	private int vehicleDailyHireRate;
	
	public Vehicle (String vehicleMake, String vehicleModel, int vehicleTopSpeed, String vehicleRegNo, int vehicleDailyHireRate) {
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleTopSpeed = vehicleTopSpeed;
		this.vehicleRegNo = vehicleRegNo;
		this.vehicleDailyHireRate = vehicleDailyHireRate;
	}
	
	public String getVehicleMake() {
		return this.vehicleMake;
	}
	
	public String getVehicleModel() {
		return this.vehicleModel;
	}
	
	public String getVehicleRegNo() {
		return this.vehicleRegNo;
	}
	
	public int getVehicleTopSpeed() {
		return this.vehicleTopSpeed;
	}
	
	public int getVehicleDailyHireRate() {
		return this.vehicleDailyHireRate;
	}
	
}
