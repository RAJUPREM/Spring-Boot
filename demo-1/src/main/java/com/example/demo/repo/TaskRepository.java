package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer>{
	//public Task findByUserEntity(int UserEntity);
}