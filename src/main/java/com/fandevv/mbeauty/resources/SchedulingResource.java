package com.fandevv.mbeauty.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandevv.mbeauty.entities.Scheduling;
import com.fandevv.mbeauty.services.SchedulingService;

@RestController
@RequestMapping(value = "/schedulings")
public class SchedulingResource {
	
	@Autowired
	private SchedulingService schedulingService;
	
	@GetMapping
	public ResponseEntity<List<Scheduling>> findAll() {
		
		List<Scheduling> listSchedulings = schedulingService.findAll();
		return ResponseEntity.ok().body(listSchedulings);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Scheduling> findById(@PathVariable Integer id) {
		
		Scheduling scheduling = schedulingService.findById(id);
		return ResponseEntity.ok().body(scheduling);
	}
	
	@GetMapping(value = "/range/{range}")
	public ResponseEntity<List<Scheduling>> schedulingsPerRange(@PathVariable String range) {
		
		List<Scheduling> schedulings = schedulingService.findPerRange(range);
		return ResponseEntity.ok().body(schedulings);
	}

}
