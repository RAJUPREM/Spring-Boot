package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskAddEmployee;
import com.example.demo.entity.TaskReq;
import com.example.demo.entity.TaskReq;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityReq;
import com.example.demo.servImpl.ServImpl;

@RestController
@RequestMapping("task")
public class UserContoller {
	
	@Autowired
	ServImpl servImpl;
	
	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody UserEntityReq userEntityReq)
	{
		servImpl.createEmployee(userEntityReq);
	}
	
	@PostMapping("/createTask")
	public void createTask(@RequestBody TaskReq taskReq)
	{
		servImpl.createTask(taskReq);
	}
	
	
	@PostMapping("/createManager")
	public void createManager(@RequestBody UserEntityReq userEntityReq)
	{
		servImpl.createManager(userEntityReq);
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<UserEntity> getEmployee(@PathVariable("employeeId") int employeeId)
	{
		UserEntity userEntity=servImpl.getEmployee(employeeId);
		return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
	}
	
	@GetMapping("/getTask/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") int taskId)
	{
		Task task=servImpl.getTask(taskId);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@GetMapping("/getManager/{managerId}")
	public ResponseEntity<UserEntity> getManager(@PathVariable("managerId") int managerId)
	{
		UserEntity userEntity=servImpl.getManager(managerId);
		return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
	}
	
	@PostMapping("/addTaskToEmployee")
	public ResponseEntity<String> addTaskToEmployee(@RequestBody TaskAddEmployee taskAddEmployee)
	{
		String res=servImpl.addTaskToEmployee(taskAddEmployee.getTaskId(), taskAddEmployee.getEmpUserEntityId(), taskAddEmployee.getManUserEntityId());
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/getTask")
	public ResponseEntity<List<Task>> getAllTask()
	{
		List<Task> ltask=servImpl.getAllTask();
		return new ResponseEntity<List<Task>>(ltask,HttpStatus.OK);
	}
	
	@GetMapping("/getTaskByEmp/{employeeId}")
	public ResponseEntity<List<Task> > getTaskByEmployeeId(@PathVariable("employeeId") int employeeId)
	{
		List<Task> lTask=servImpl.getTaskByEmployeeId(employeeId);
		return new ResponseEntity<List<Task> >(lTask,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteTaskOfEmpByEmpId")
	public void deleteTaskOfEmpByEmpId(@RequestBody TaskAddEmployee taskAddEmployee)
	{
		servImpl.deleteTaskOfEmpByEmpId(taskAddEmployee);
	}

	@PutMapping("/getEmployee/{employeeId}/{changedEmpId}/{managerId}")
	public ResponseEntity<Task> updateTaskOfEmpByEmpId(@PathVariable("employeeId") int employeeId,@PathVariable("changedEmpId") int changedEmpId,@PathVariable("managerId") int managerId,@RequestBody TaskReq taskReq)
	{
		Task task=servImpl.updateTaskOfEmpByEmpId(employeeId, changedEmpId,managerId, taskReq);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
}
