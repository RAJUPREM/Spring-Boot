package com.example.demo.serv;

import com.example.demo.entity.UserEntity;

public interface Serv {
	
	public void createEmployee(UserEntity userEntity);
	
	public void createManager(UserEntity userEntity);
	
	public UserEntity getEmployee(int userEntityId);
	
	public UserEntity getManager(int userEntityId);
	
	

}
