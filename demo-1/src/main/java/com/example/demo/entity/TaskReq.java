package com.example.demo.entity;

public class TaskReq {
	
	public TaskReq() {
		super();
	}
	public TaskReq(int taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}
	private int taskId;
	private String taskName;
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
	@Override
	public String toString() {
		return "TaskReq [taskId=" + taskId + ", taskName=" + taskName + "]";
	}

}
