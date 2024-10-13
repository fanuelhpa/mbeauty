package com.fandevv.mbeauty.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandevv.mbeauty.dto.ScheduleDTO;
import com.fandevv.mbeauty.entities.Schedule;
import com.fandevv.mbeauty.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleResource {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping
	public ResponseEntity<List<ScheduleDTO>> findAll() {
		
		List<Schedule> listSchedules = scheduleService.findAll();
		
		//Convert each schedule from listSchedules to scheduleDTO and make a list of this
		List<ScheduleDTO> listSchedulesDTO = listSchedules.stream().map(x -> new ScheduleDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listSchedulesDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Integer id) {
		
		Schedule schedule = scheduleService.findById(id);
		return ResponseEntity.ok().body(schedule);
	}
	
	@GetMapping(value = "/range/{range}")
	public ResponseEntity<List<Schedule>> schedulingsPerRange(@PathVariable String range) {
		
		List<Schedule> schedulings = scheduleService.findScheduleRange(range);
		return ResponseEntity.ok().body(schedulings);
	}
	
	//Send a schedule to data persistence and return a scheduleDTO
	@PostMapping
	public ResponseEntity<ScheduleDTO> insert(@RequestBody Schedule schedule){
		
		schedule = scheduleService.insert(schedule);
		ScheduleDTO returnedData = new ScheduleDTO(schedule);
		return ResponseEntity.ok().body(returnedData);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		scheduleService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
