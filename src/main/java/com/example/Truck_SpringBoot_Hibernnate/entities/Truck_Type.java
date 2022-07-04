package com.example.Truck_SpringBoot_Hibernnate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "truck_type",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Truck_Type {
	
	@Id
	private String name;
	
}
