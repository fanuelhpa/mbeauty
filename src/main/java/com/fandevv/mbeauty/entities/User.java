package com.fandevv.mbeauty.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import com.fandevv.mbeauty.entities.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	private Integer userType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Schedule> schedulings = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Phone> phones = new ArrayList<>();
	
	public User () {
	}

	public User(Integer id, String name, String email, String password, UserType userType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		setUserType(userType);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserType getUserType() {
		return UserType.valueOf(userType);
	}

	public void setUserType(UserType userType) {
		
		if(userType != null) {
			this.userType = userType.getCode();
		}
	}
	
	public List<Schedule> getSchedulings() {
		return schedulings;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
