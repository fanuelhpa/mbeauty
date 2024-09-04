package com.fandevv.mbeauty.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		return user.orElse(null);
	}
}
