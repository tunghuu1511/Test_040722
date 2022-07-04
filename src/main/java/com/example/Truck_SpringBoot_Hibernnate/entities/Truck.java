package com.example.Truck_SpringBoot_Hibernnate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "truck",schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type_name")
	private String type_name;
	
	
	@Column(name="license")
	private String license;
}
