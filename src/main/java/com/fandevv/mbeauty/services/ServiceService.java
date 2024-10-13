package com.fandevv.mbeauty.services;


import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fandevv.mbeauty.entities.Service;
import com.fandevv.mbeauty.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	//Retrieve all services from DB
	public List<Service> findAll(){
		
		List<Service> services = serviceRepository.findAll();
		return services;
	}
	
	public Service findById(Integer id) {
		
		Optional<Service> service = serviceRepository.findById(id);
		
		if (service == null) {
			
			throw new ObjectNotFoundException("Service not found", service);	
		}
		else {
		
			return service.get();
		}
	}
	
	//Insert a service into the database
	public Service insert(Service service) {
		
		return serviceRepository.save(service);
	}
}
