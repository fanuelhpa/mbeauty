package com.fandevv.mbeauty.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fandevv.mbeauty.entities.Schedule;

public class ScheduleDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//private Instant scheduleDate;
	private String date;
	private String hour;
	private Double price;
	private UserDTO user;
	private ServiceDTO service;
	
	public ScheduleDTO() {
		
	}
	public ScheduleDTO(Schedule schedule) {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
		
		id = schedule.getId();
		
		//Gera um objeto Date através do objeto Instant e retorna um string através do sdfDate para a variável string date
		date = sdfDate.format(Date.from(schedule.getScheduleDate()));
		hour = sdfHour.format(Date.from(schedule.getScheduleDate()));
		
		price = schedule.getPrice();
		
		//Create userDTO and serviceDTO based on user and service
		user = new UserDTO(schedule.getUser());
		service = new ServiceDTO(schedule.getService());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.user = userDTO;
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO serviceDTO) {
		this.service = serviceDTO;
	}
}
