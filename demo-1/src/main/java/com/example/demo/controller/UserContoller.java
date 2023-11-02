package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.servImpl.ServImpl;

@RestController
@RequestMapping("task")
public class UserContoller {
	
	@Autowired
	ServImpl servImpl;
	
	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody UserEntity userEntity)
	{
		servImpl.createEmployee(userEntity);
	}
	
	@PostMapping("/createManager")
	public void createManager(@RequestBody UserEntity userEntity)
	{
		servImpl.createManager(userEntity);
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<UserEntity> getEmployee(@PathVariable("employeeId") int employeeId)
	{
		UserEntity userEntity=servImpl.getEmployee(employeeId);
		return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
	}
	
	@GetMapping("/getManager/{managerId}")
	public ResponseEntity<UserEntity> getManager(@PathVariable("managerId") int managerId)
	{
		UserEntity userEntity=servImpl.getManager(managerId);
		return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
	}

}
