package com.fandevv.mbeauty.entities.enums;

public enum ServiceType {
	
	HAIR(1),
	HAND(2),
	FOOTANDHAND(3);
	
	private int code;
	
	private ServiceType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ServiceType valueOf(int code) {
		
		for (ServiceType value : ServiceType.values()) {
		
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ServiceType code.");
	}
}
