package com.example.Truck_SpringBoot_Hibernnate.service;

import java.util.List;

import com.example.Truck_SpringBoot_Hibernnate.entities.Truck;

public interface TruckService{
	public abstract Truck findTruckByID(int id) throws Exception;
	public abstract Truck saveTruck(Truck truck);
	public abstract Truck updateTruck(Truck truck);
	public abstract boolean deleteTruck(int id);
	public abstract List<Truck> findAllTruck(); 
	public abstract List<Truck> findByFilter(String filter);
	public abstract List<Truck> findTruckByName(String name);
}
