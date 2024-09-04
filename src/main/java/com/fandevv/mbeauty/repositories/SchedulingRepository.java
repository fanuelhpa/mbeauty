package com.fandevv.mbeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandevv.mbeauty.entities.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
	
}