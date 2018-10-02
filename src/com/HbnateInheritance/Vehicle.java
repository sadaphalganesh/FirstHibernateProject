package com.HbnateInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

//TRY FOR THE OTHER TWO INHERITANCE STRATEGIES
//SINGLE_TABLE,JOINED,TABLE_PER_CLASS
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleID;
	private String vehicleName;
	
	
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
	
	

}
