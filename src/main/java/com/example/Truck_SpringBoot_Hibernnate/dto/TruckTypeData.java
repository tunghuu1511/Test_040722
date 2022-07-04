package com.example.Truck_SpringBoot_Hibernnate.dto;

import com.example.Truck_SpringBoot_Hibernnate.entities.Truck_Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckTypeData {

	private String name;
	
	public Truck_Type toStruckType() {
		Truck_Type truck_Type=new Truck_Type();
		truck_Type.setName(name);
		return truck_Type;
	}
	
	public static TruckTypeData fromTruckType(Truck_Type truck_Type)
	{
		return new TruckTypeData(truck_Type.getName());
	}
	
}
