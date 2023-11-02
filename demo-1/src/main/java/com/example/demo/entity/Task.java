package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	public Task() {
		super();
	}

	public Task(int taskId, String taskName, UserEntity userEntity) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.userEntity = userEntity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private UserEntity userEntity;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", userEntity=" + userEntity + "]";
	}
	
	

}
