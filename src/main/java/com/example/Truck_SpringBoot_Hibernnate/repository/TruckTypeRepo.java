package com.example.Truck_SpringBoot_Hibernnate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Truck_SpringBoot_Hibernnate.entities.Truck_Type;

@Repository
public interface TruckTypeRepo extends JpaRepository<Truck_Type	, String>{

}
