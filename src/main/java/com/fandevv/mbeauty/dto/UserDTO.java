package com.fandevv.mbeauty.dto;

import java.io.Serializable;

import com.fandevv.mbeauty.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	
	public UserDTO() {
		
	}
	public UserDTO(User user) {
		
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
