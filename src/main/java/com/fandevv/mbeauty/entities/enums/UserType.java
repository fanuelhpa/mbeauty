package com.fandevv.mbeauty.entities.enums;

public enum UserType {
	
	ADMINISTRATOR(0),
	CLIENT(1);

	private int code;
	
	private UserType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static UserType valueOf(int code) {
		
		for (UserType value : UserType.values()) {
		
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid UserType code.");
	}
}
