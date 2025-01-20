package com.taskmanager.task.service;

import java.util.List;

import com.taskmanager.task.dto.TaskDTO;
import com.taskmanager.task.exception.TaskManagerException;

public interface TaskService {
	
	public TaskDTO getTask(long id) throws TaskManagerException;
	
	public TaskDTO addTask(TaskDTO dto) throws TaskManagerException;
	
	public TaskDTO updateTask(long id, TaskDTO dto) throws TaskManagerException;
	
	public long deleteTask(long id) throws TaskManagerException;
	
	public List<TaskDTO> getTasksByEmployeeId(long employeeId) throws TaskManagerException;
}
