package com.example.Truck_SpringBoot_Hibernnate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Truck_SpringBoot_Hibernnate.entities.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer>,QuerydslPredicateExecutor<Truck>{

	@Query(value = "select t.* from \"truck\" t where t.\"type_name\" like %:filter% ",nativeQuery = true)
	List<Truck> filterType(@Param("filter") String filter );
	
	
}
