package com.example.Truck_SpringBoot_Hibernnate.dto;

import com.example.Truck_SpringBoot_Hibernnate.entities.Truck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckData {

	private int id;
	private String type;
	private String license;
	
	public Truck toTruck() {
		Truck truck = new Truck();
		truck.setId(id);
		truck.setType_name(type);
		truck.setLicense(license);
		return truck;
	}
	
	public static TruckData fromTruck(Truck truck) {
		return new TruckData(truck.getId(),truck.getType_name(),truck.getLicense());
	}
}
