package com.example.SpringBootBegining5.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity

@Embeddable
public class Address {
	
	
	public Address() {
		super();
		
	}
	public Address(int pinNumber, String district, String state) {
		super();
		this.pinNumber = pinNumber;
		this.district = district;
		this.state = state;
	}
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pinNumber;
	private String district;
	private String state;
	
	//@OneToOne(mappedBy="studentId")
	//private Student student;
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [pinNumber=" + pinNumber + ", district=" + district + ", state=" + state + "]";
	}

}
