package com.taskmanager.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.taskmanager.task.entity.Task;

public interface TaskRepository extends ListCrudRepository<Task,Long>{
	
	List<Task> findAllByEmployeeId(long employeeId);
	
}
