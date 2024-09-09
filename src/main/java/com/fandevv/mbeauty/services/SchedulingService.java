package com.fandevv.mbeauty.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandevv.mbeauty.entities.Scheduling;
import com.fandevv.mbeauty.repositories.SchedulingRepository;

@Service
public class SchedulingService {

	@Autowired
	private SchedulingRepository schedulingRepository;
	
	public List<Scheduling> findAll(){
		return schedulingRepository.findAll();
	}
	
	public Scheduling findById(Integer id) {
		
		Optional<Scheduling> scheduling = schedulingRepository.findById(id);
		
		return scheduling.orElse(null);
	}
	
	//Recupera uma  lista de schedulings baseado em um range de datas.
	public List<Scheduling> findPerRange(String range) {
		
		String start_ = range.substring(0, 10);
		String end_ = range.substring(10, 20);	
		Instant start = Instant.parse(start_ + "T00:00:00Z");
		Instant end = Instant.parse(end_ + "T23:59:59Z");;

		List<Scheduling> schedulings = schedulingRepository.findBySchedulingDateBetween(start, end);
			
		return schedulings;		
	}

}
