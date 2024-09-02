package com.fandevv.mbeauty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fandevv.mbeauty.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
