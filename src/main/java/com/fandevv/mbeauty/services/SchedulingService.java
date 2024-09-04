package com.fandevv.mbeauty.services;

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
}
