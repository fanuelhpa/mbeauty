package com.fandevv.mbeauty.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
