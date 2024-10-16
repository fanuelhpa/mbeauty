package com.fandevv.mbeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandevv.mbeauty.dto.ServiceDTO;
import com.fandevv.mbeauty.entities.Service;
import com.fandevv.mbeauty.services.ServiceService;

@RestController
@RequestMapping(value = "/services")
public class ServiceResource {
	
	@Autowired
	private ServiceService serviceService;
	
	
	//Find all
	@GetMapping
	public ResponseEntity<List<Service>> findAll(){
		
		List<Service> services = serviceService.findAll();
				
		return ResponseEntity.ok().body(services);
	}
	
	//Find by ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Service> findById(@PathVariable Integer id){
		
		Service service = serviceService.findById(id);
		
		return ResponseEntity.ok().body(service);
	}
	
	//Insert
	@PostMapping
	public ResponseEntity<ServiceDTO> insert(@RequestBody Service service){
		
		service = serviceService.insert(service);
		ServiceDTO returned = new ServiceDTO(service);
		
		return ResponseEntity.ok().body(returned);
	}
}
