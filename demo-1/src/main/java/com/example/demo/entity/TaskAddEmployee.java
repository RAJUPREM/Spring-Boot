package com.example.demo.entity;

public class TaskAddEmployee {
	
	public TaskAddEmployee() {
		super();
	}
	public TaskAddEmployee(int taskId, int empUserEntityId, int manUserEntityId) {
		super();
		this.taskId = taskId;
		this.empUserEntityId = empUserEntityId;
		this.manUserEntityId = manUserEntityId;
	}
	private int taskId;
	private int empUserEntityId;
	private int manUserEntityId;
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getEmpUserEntityId() {
		return empUserEntityId;
	}
	public void setEmpUserEntityId(int empUserEntityId) {
		this.empUserEntityId = empUserEntityId;
	}
	public int getManUserEntityId() {
		return manUserEntityId;
	}
	public void setManUserEntityId(int manUserEntityId) {
		this.manUserEntityId = manUserEntityId;
	}
	@Override
	public String toString() {
		return "TaskAddEmployee [taskId=" + taskId + ", empUserEntityId=" + empUserEntityId + ", manUserEntityId="
				+ manUserEntityId + "]";
	}

}
