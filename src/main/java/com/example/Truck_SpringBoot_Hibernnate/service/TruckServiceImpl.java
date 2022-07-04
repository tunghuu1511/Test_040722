package com.example.Truck_SpringBoot_Hibernnate.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Truck_SpringBoot_Hibernnate.entities.QTruck;
import com.example.Truck_SpringBoot_Hibernnate.entities.Truck;
import com.example.Truck_SpringBoot_Hibernnate.repository.TruckRepository;
import com.example.Truck_SpringBoot_Hibernnate.repository.TruckTypeRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class TruckServiceImpl implements TruckService{

	@Autowired
	TruckRepository truckRepo;
	
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Truck");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	@PersistenceContext()
	EntityManager entityManager ;
	
	
	@Autowired
	TruckTypeRepo truckTypeRepo;
	@Override
	public Truck findTruckByID(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Truck> truck= truckRepo.findById(id);
		if (truck.isPresent()) {
			return truck.get();
		}
		throw new Exception("not found");
	}

	@Override
	public Truck saveTruck(Truck truck) {
		// TODO Auto-generated method stub
		
		return truckRepo.save(truck);
	}

	@Override
	public Truck updateTruck(Truck truck) {
		// TODO Auto-generated method stub
		return truckRepo.save(truck);
	}

	@Override
	public boolean deleteTruck(int id) {
		// TODO Auto-generated method stub
		truckRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Truck> findAllTruck() {
		// TODO Auto-generated method stub
		return truckRepo.findAll();
	}

	@Override
	public List<Truck> findByFilter(String filter) {
		// TODO Auto-generated method stub
		return truckRepo.filterType(filter);
	}

	@Override
	public List<Truck> findTruckByName(String name) {
		// TODO Auto-generated method stub
		
		JPAQueryFactory queryFactory=new JPAQueryFactory(entityManager);
		QTruck qTruck=QTruck.truck;
		return queryFactory.selectFrom(qTruck).where(qTruck.type_name.eq(name)).fetch();
	}

}
