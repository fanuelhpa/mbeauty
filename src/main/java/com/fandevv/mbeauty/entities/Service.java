package com.fandevv.mbeauty.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fandevv.mbeauty.entities.enums.ServiceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_service")
public class Service implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	private Integer serviceType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "service")
	private List<Scheduling> schedulings = new ArrayList<>();
	
	public Service() {
		
	}

	public Service(Integer id, String name, Double price, ServiceType serviceType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		setServiceType(serviceType);
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
	
	public ServiceType getServiceType() {
		return ServiceType.valueOf(serviceType);
	}

	public void setServiceType(ServiceType serviceType) {
		
		if(serviceType != null) {
			this.serviceType = serviceType.getCode();
		}
		
	}

	public List<Scheduling> getSchedulings() {
		return schedulings;
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
		Service other = (Service) obj;
		return Objects.equals(id, other.id);
	}
}
