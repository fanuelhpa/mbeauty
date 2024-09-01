package com.fandevv.mbeauty.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandevv.mbeauty.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		
		User user1 = new User(1, "Fanuel", "fanuel@gmail.com", "12345678");
		return ResponseEntity.ok().body(user1);
	}
	
}
