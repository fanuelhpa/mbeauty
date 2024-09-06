package com.fandevv.mbeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandevv.mbeauty.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
	
}
