package com.fandevv.mbeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandevv.mbeauty.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
	
}
