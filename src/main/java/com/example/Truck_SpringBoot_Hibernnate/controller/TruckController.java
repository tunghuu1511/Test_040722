package com.example.Truck_SpringBoot_Hibernnate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Truck_SpringBoot_Hibernnate.dto.TruckData;
import com.example.Truck_SpringBoot_Hibernnate.entities.Truck;
import com.example.Truck_SpringBoot_Hibernnate.service.TruckService;

@RestController
public class TruckController {

	@Autowired
	TruckService truckService;
	
	@GetMapping("/")
	public ResponseEntity<List<TruckData>> getAllTruck()
	{
		List<TruckData> list=new ArrayList<TruckData>();
		truckService.findAllTruck().forEach(c->list.add(TruckData.fromTruck(c)));
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TruckData> getTruck(@PathVariable int id) throws Exception
	{
		return ResponseEntity.ok(TruckData.fromTruck(truckService.findTruckByID(id)));
	}
	
	@PostMapping("/")
	public ResponseEntity<TruckData> newTruck(@RequestBody TruckData data)
	{
		Truck truck= truckService.saveTruck(data.toTruck());
		return ResponseEntity.ok(TruckData.fromTruck(truck));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TruckData> updateTruck(@RequestBody TruckData data,@PathVariable ("id") int id)
	{
		Truck truck = data.toTruck();
		truck.setId(id);
		truckService.updateTruck(truck);
		return ResponseEntity.ok(TruckData.fromTruck(truck));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTruck(@PathVariable int id) throws NotFoundException
	{
		truckService.deleteTruck(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/filter/{type}")
	public ResponseEntity<List<TruckData>> filterTruck(@PathVariable String type)
	{
		List<TruckData> list=new ArrayList<TruckData>();
		truckService.findByFilter(type).forEach(c->list.add(TruckData.fromTruck(c)));
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/typename")
	public ResponseEntity<List<TruckData>> getTruckByName(@PathParam("type") String name)
	{
		List<TruckData> list=new ArrayList<TruckData>();
		truckService.findTruckByName(name).forEach(c->list.add(TruckData.fromTruck(c)));
		return ResponseEntity.ok(list);
	}
}
