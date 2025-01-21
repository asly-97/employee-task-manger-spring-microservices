package com.taskmanager.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.taskmanager.task.client.EmployeeClient;
import com.taskmanager.task.dto.EmployeeDTO;
import com.taskmanager.task.dto.TaskDTO;
import com.taskmanager.task.entity.Task;
import com.taskmanager.task.exception.TaskManagerException;
import com.taskmanager.task.repository.TaskRepository;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private EmployeeClient employeeClient;

	@Override
	public TaskDTO getTask(long id) throws TaskManagerException {
		Task task = repo.findById(id)
				.orElseThrow(
						() -> new TaskManagerException("Task Not Found",HttpStatus.NOT_FOUND)
				);
		
		return TaskDTO.prepareDTO(task);
	}
	
	@Override
	public List<TaskDTO> getAllTasks() throws TaskManagerException {
		return repo.findAll()
				.stream()
				.map(e -> TaskDTO.prepareDTO(e))
				.collect(Collectors.toList());
	}

	@CircuitBreaker(name = "emp-ms-cb",fallbackMethod = "addTaskFallback")
	@Override
	public TaskDTO addTask(TaskDTO dto) throws TaskManagerException {
		
		LogFactory.getLog(this.getClass()).error("+++++++ In addTask() Method ++++++++++");
		
		Task task = TaskDTO.prepareEntity(dto);
	
		
		
		
		try {
			EmployeeDTO empDto = employeeClient.getEmployeeById(dto.getEmployeeId());
		}
		catch(FeignException.BadRequest e) {
			throw new TaskManagerException("The given employee id doesn't exists",HttpStatus.NOT_FOUND); 
		}
		
		task = repo.save(task);
		
		return TaskDTO.prepareDTO(task);
	}
	
	public TaskDTO addTaskFallback(TaskDTO dto, Exception e) throws Exception {
		LogFactory.getLog(this.getClass()).error("+++++++ In Fallback Method ++++++++++");
		//LogFactory.getLog(this.getClass()).error(e);
		
		// Re-throw ignored exceptions
	    if (e instanceof TaskManagerException) {
	        throw e;
	    }
		
		TaskDTO taskDTO = new TaskDTO();
		
		return taskDTO;
	}

	@Override
	public TaskDTO updateTask(long id, TaskDTO dto) throws TaskManagerException {
		Task task = repo.findById(id)
				.orElseThrow(
						() -> new TaskManagerException("Task Not Found",HttpStatus.NOT_FOUND)
				);
		
		if(dto.getTitle() != null) {
			task.setTitle(dto.getTitle());
		}
		
		if(dto.getDescription() != null) {
			task.setDescription(dto.getDescription());
		}
		
		if(dto.getStatus() != null) {
			task.setStatus(dto.getStatus());
		}
		
		task = repo.save(task);
		
		return TaskDTO.prepareDTO(task);
	}

	@Override
	public long deleteTask(long id) throws TaskManagerException {
		Task task = repo.findById(id)
				.orElseThrow(
						() -> new TaskManagerException("Task Not Found",HttpStatus.NOT_FOUND)
				);
		
		repo.delete(task);
		
		return id;
	}

	@Override
	public List<TaskDTO> getTasksByEmployeeId(long employeeId) throws TaskManagerException {
		return repo.findAllByEmployeeId(employeeId)
				.stream()
				.map(e -> TaskDTO.prepareDTO(e))
				.collect(Collectors.toList());
	}

}
