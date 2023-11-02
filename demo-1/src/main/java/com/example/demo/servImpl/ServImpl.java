package com.example.demo.servImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserEntityReposiotry;
import com.example.demo.serv.Serv;

@Service
public class ServImpl implements Serv{

	@Autowired
	UserEntityReposiotry userEntityReposiotry;
	
	@Override
	public void createEmployee(UserEntity userEntity) {
		userEntityReposiotry.save(userEntity);
		
	}

	@Override
	public void createManager(UserEntity userEntity) {
		userEntityReposiotry.save(userEntity);
		
	}

	@Override
	public UserEntity getEmployee(int userEntityId) {
		Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(userEntityId);
		UserEntity userEntity=tempUserEntity.get();
		return userEntity;
		
	}

	@Override
	public UserEntity getManager(int userEntityId) {
		Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(userEntityId);
		UserEntity userEntity=tempUserEntity.get();
		return userEntity;
	}

}
