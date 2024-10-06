package com.fandevv.mbeauty.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandevv.mbeauty.dto.UserDTO;
import com.fandevv.mbeauty.entities.User;
import com.fandevv.mbeauty.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> listUsers = userService.findAll();
		
		//Becomes listUsers to listDTO
		List<UserDTO> listUsersDTO = listUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listUsersDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
}
