package com.fandevv.mbeauty.dto;

import java.io.Serializable;

import com.fandevv.mbeauty.entities.Service;

public class ServiceDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double price;
	
	public ServiceDTO() {
		
	}
	public ServiceDTO(Service service) {
		
		id = service.getId();
		name = service.getName();
		price = service.getPrice();
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
