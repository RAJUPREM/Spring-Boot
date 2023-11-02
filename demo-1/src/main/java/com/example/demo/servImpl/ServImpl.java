package com.example.demo.servImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskAddEmployee;
import com.example.demo.entity.TaskReq;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserEntityReq;
import com.example.demo.repo.TaskRepository;
import com.example.demo.repo.UserEntityReposiotry;
import com.example.demo.serv.Serv;

@Service
public class ServImpl implements Serv{

	@Autowired
	UserEntityReposiotry userEntityReposiotry;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public void createEmployee(UserEntityReq userEntityReq) {
		UserEntity tempUserEntity=new UserEntity();
		
		tempUserEntity.setUserEntityId(userEntityReq.getUserEntityId());
		tempUserEntity.setFirstName(userEntityReq.getFirstName());
		tempUserEntity.setLastName(userEntityReq.getLastName());
		tempUserEntity.setStartDate(userEntityReq.getStartDate());
		tempUserEntity.setEndDate(userEntityReq.getEndDate());
		tempUserEntity.setAccessRight(userEntityReq.getAccessRight());
		
		userEntityReposiotry.save(tempUserEntity);
		
	}
	
	@Override
	public void createTask(TaskReq taskReq) {
		Task tempTask=new Task();
		tempTask.setTaskId(taskReq.getTaskId());
		tempTask.setTaskName(taskReq.getTaskName());
		taskRepository.save(tempTask);
		
	}

	@Override
	public void createManager(UserEntityReq userEntityReq) {
		
UserEntity tempUserEntity=new UserEntity();
		
		tempUserEntity.setUserEntityId(userEntityReq.getUserEntityId());
		tempUserEntity.setFirstName(userEntityReq.getFirstName());
		tempUserEntity.setLastName(userEntityReq.getLastName());
		tempUserEntity.setStartDate(userEntityReq.getStartDate());
		tempUserEntity.setEndDate(userEntityReq.getEndDate());
		tempUserEntity.setAccessRight(userEntityReq.getAccessRight());
		
		userEntityReposiotry.save(tempUserEntity);
		
	}

	@Override
	public UserEntity getEmployee(int userEntityId) {
		Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(userEntityId);
		UserEntity userEntity=tempUserEntity.get();
		return userEntity;
		
	}
	
	@Override
	public Task getTask(int taskId) {
		Optional<Task> tempTask=taskRepository.findById(taskId);
		Task task=tempTask.get();
		return task;
	}

	@Override
	public UserEntity getManager(int userEntityId) {
		Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(userEntityId);
		UserEntity userEntity=tempUserEntity.get();
		return userEntity;
	}

	@Override
	public String addTaskToEmployee(int taskId, int empUserEntityId,int manUserEntityId) {
		try {
		Optional<UserEntity> tempEmpUserEntity=userEntityReposiotry.findById(empUserEntityId);
		UserEntity empUserEntity=tempEmpUserEntity.get();
		
		Optional<Task> tempTask=taskRepository.findById(taskId);
		Task task=tempTask.get();
		
		if(empUserEntity.getAccessRight().equals("N"))
		{
			Optional<UserEntity> tempManUserEntity=userEntityReposiotry.findById(manUserEntityId);
			UserEntity manUserEntity=tempManUserEntity.get();
			
			if(manUserEntity.getAccessRight().equals("Y"))
			{
				task.setUserEntity(empUserEntity);
				taskRepository.save(task);
				
				return "Task Added";
			}
			else
			{
				return "This is not manager";
			}
		}
		else
		{
			return "This is not employee";
		}
		}
		catch(NoSuchElementException noSuchElementException)
		{
			return "No such data is present";
		}
		
		
		
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> ltask=taskRepository.findAll();
		return ltask;
	}

	@Override
	public List<Task> getTaskByEmployeeId(int userEntityId) {
		List<Task> lTask=taskRepository.findAll();
		
		List<Task> lTaskEmp=new ArrayList<Task>();
		
		for(Task t:lTask)
		{
			if(t.getUserEntity().getUserEntityId()==userEntityId)
			{
				lTaskEmp.add(t);
			}
		}
		
		
		return lTaskEmp;
	}

	@Override
	public void deleteTaskOfEmpByEmpId(TaskAddEmployee taskAddEmployee) {
		
		Optional<UserEntity> tempEmpUserEntity=userEntityReposiotry.findById(taskAddEmployee.getEmpUserEntityId());
		UserEntity empUserEntity=tempEmpUserEntity.get();
		
		Optional<UserEntity> tempManUserEntity=userEntityReposiotry.findById(taskAddEmployee.getManUserEntityId());
		UserEntity manUserEntity=tempManUserEntity.get();
		
		List<Task> lTask=taskRepository.findAll();
		
		List<Task> lTaskEmp=new ArrayList<Task>();
		
		if(manUserEntity.getAccessRight().equals("Y"))
		{
		for(Task t:lTask)
		{
			if(t.getUserEntity().getUserEntityId()==taskAddEmployee.getEmpUserEntityId() && t.getTaskId()==taskAddEmployee.getTaskId())
			{
				t.setUserEntity(null);
				taskRepository.save(t);
			}
		}

	}
	}

	@Override
	public Task updateTaskOfEmpByEmpId(int userEntityId,int changedEmp,int managerId, TaskReq taskReq) {
		
		Optional<UserEntity> tempManUserEntity=userEntityReposiotry.findById(managerId);
		UserEntity manUserEntity=tempManUserEntity.get();
		
		List<Task> lTask=taskRepository.findAll();
		
		List<Task> lTaskEmp=new ArrayList<Task>();
		
		if(manUserEntity.getAccessRight().equals("Y"))
		{
		for(Task t:lTask)
		{
			if(t.getUserEntity()!=null)
			{
			if(t.getUserEntity().getUserEntityId()==userEntityId && t.getTaskId()==taskReq.getTaskId())
			{
				t.setTaskName(taskReq.getTaskName());
				Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(changedEmp);
				UserEntity userEntity=tempUserEntity.get();
				t.setUserEntity(userEntity);
				taskRepository.save(t);
				return t;
			}
			}
//			else if
//			{
//				t.setTaskName(taskReq.getTaskName());
//				Optional<UserEntity> tempUserEntity=userEntityReposiotry.findById(changedEmp);
//				UserEntity userEntity=tempUserEntity.get();
//				t.setUserEntity(userEntity);
//				taskRepository.save(t);
//				return t;
//			}
		}
		}
		
		return null;
		
	}



	

}
