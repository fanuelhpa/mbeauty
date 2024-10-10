package com.fandevv.mbeauty.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fandevv.mbeauty.entities.Schedule;
import com.fandevv.mbeauty.entities.Service;
import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.repositories.ScheduleRepository;

@org.springframework.stereotype.Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ServiceService serviceService;
	
	public List<Schedule> findAll(){
		return scheduleRepository.findAll();
	}
	
	public Schedule findById(Integer id) {
		
		Optional<Schedule> scheduling = scheduleRepository.findById(id);
		
		return scheduling.orElse(null);
	}
	
	//Recupera uma  lista de schedules baseado em um range de datas.
	public List<Schedule> findScheduleRange(String range) {
		
		String start_ = range.substring(0, 10);
		String end_ = range.substring(10, 20);	
		Instant start = Instant.parse(start_ + "T00:00:00Z");
		Instant end = Instant.parse(end_ + "T23:59:59Z");;

		List<Schedule> schedulings = scheduleRepository.findByScheduleDateBetween(start, end);
			
		return schedulings;		
	}
	
	public Schedule insert(Schedule schedule) {
		
		User user = userService.findById(schedule.getUser().getId());
		Service service = serviceService.findById(schedule.getService().getId());
		
		schedule.setUser(user);
		schedule.setService(service);
		schedule.setPrice(service.getPrice());
		
		return scheduleRepository.save(schedule);
	}
	

}
