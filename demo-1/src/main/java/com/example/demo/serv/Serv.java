package com.example.demo.serv;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskReq;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityReq;

public interface Serv {
	
	public void createEmployee(UserEntityReq userEntityReq);
	
	public void createTask(TaskReq taskReq);
	
	public void createManager(UserEntityReq userEntityReq);
	
	public UserEntity getEmployee(int userEntityId);
	
	public Task getTask(int taskId);
	
	public UserEntity getManager(int userEntityId);
	
	public String addTaskToEmployee(int taskId, int empUserEntityId,int manUserEntityId);
	

}
