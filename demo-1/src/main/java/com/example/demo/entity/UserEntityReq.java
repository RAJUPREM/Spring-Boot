package com.example.demo.entity;

public class UserEntityReq {
	
	public UserEntityReq() {
		super();
	}
	public UserEntityReq(int userEntityId, String firstName, String lastName, String startDate, String endDate,
			String accessRight) {
		super();
		this.userEntityId = userEntityId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.accessRight = accessRight;
	}
	private int userEntityId;
	private String firstName;
	private String lastName;
	private String startDate;
	private String endDate;
	private String accessRight;
	public int getUserEntityId() {
		return userEntityId;
	}
	public void setUserEntityId(int userEntityId) {
		this.userEntityId = userEntityId;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}
	@Override
	public String toString() {
		return "UserEntityReq [userEntityId=" + userEntityId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", accessRight=" + accessRight + "]";
	}
	

}
