package com.fandevv.mbeauty.services;


import java.util.List;
import java.util.Optional;

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
		
		return service.orElse(null);
	}
}
