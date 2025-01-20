package com.taskmanager.task.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.task.dto.TaskDTO;
import com.taskmanager.task.exception.TaskManagerException;

@Service
public class TaskServiceImpl implements TaskService{

	@Override
	public TaskDTO getTask(long id) throws TaskManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO addTask(TaskDTO dto) throws TaskManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO updateTask(long id, TaskDTO dto) throws TaskManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteTask(long id) throws TaskManagerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TaskDTO> getTasksByEmployeeId(long employeeId) throws TaskManagerException {
		// TODO Auto-generated method stub
		return null;
	}

}
