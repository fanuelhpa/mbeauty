package com.fandevv.mbeauty.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fandevv.mbeauty.entities.Schedule;

public class ScheduleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Instant scheduleDate;
	private Double price;
	private UserDTO userDTO;
	private ServiceDTO serviceDTO;
	
	public ScheduleDTO() {
		
	}
	public ScheduleDTO(Schedule schedule) {
		
		id = schedule.getId();
		scheduleDate = schedule.getScheduleDate();
		price = schedule.getPrice();
		
		//Create userDTO and serviceDTO based on user and service
		userDTO = new UserDTO(schedule.getUser());
		serviceDTO = new ServiceDTO(schedule.getService());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instant getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Instant scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public ServiceDTO getServiceDTO() {
		return serviceDTO;
	}
	public void setServiceDTO(ServiceDTO serviceDTO) {
		this.serviceDTO = serviceDTO;
	}
}
