package com.fandevv.mbeauty.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandevv.mbeauty.entities.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
	
	List<Scheduling> findBySchedulingDateBetween(Instant start, Instant end);
}