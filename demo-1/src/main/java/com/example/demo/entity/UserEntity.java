package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
	
	
	public UserEntity() {
		super();
	}
	public UserEntity(int userEntityId, String firstName, String lastName, String startDate, String endDate,
			String taskName, String accessRight) {
		super();
		this.userEntityId = userEntityId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.taskName = taskName;
		this.accessRight = accessRight;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userEntityId;
	private String firstName;
	private String lastName;
	private String startDate;
	private String endDate;
	private String taskName;
	private String accessRight;
	public int getEmployeeId() {
		return userEntityId;
	}
	public void setEmployeeId(int userEntityId) {
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
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}
	@Override
	public String toString() {
		return "UserEntity [userEntityId=" + userEntityId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", taskName=" + taskName + ", accessRight="
				+ accessRight + "]";
	}
	

}
