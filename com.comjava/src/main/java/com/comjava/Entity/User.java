package com.comjava.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id;

@Entity
public class User {
	
public User() {
		super();
		// TODO Auto-generated constructor stub
	}
public User(Long id, String firstName, String lastName, String phoneNumber, String address, double amount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.amount = amount;
	}

@Id
@GeneratedValue(strategy = GenerationType.AUTO) 
private Long id;
private String firstName;
private String lastName;
private String phoneNumber;
private String address;
private double amount;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
			+ ", address=" + address + ", amount=" + amount + "]";
}



}
