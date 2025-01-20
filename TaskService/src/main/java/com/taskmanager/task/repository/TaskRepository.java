package com.taskmanager.task.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.task.entity.Task;

public interface TaskRepository extends CrudRepository<Task,Long>{

}
