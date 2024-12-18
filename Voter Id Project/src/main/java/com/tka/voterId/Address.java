package com.tka.voterId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private int pin_code;
	private String city;

	public Address() {
		super();
	}

	public Address(int pin_code, String city) {
		super();
		this.pin_code = pin_code;
		this.city = city;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [pin_code=" + pin_code + ", city=" + city + "]";
	}

}
