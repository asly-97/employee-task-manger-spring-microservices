package com.taskmanager.task.controller;

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

import com.taskmanager.task.dto.TaskDTO;
import com.taskmanager.task.exception.TaskManagerException;
import com.taskmanager.task.service.TaskService;


@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	
	@GetMapping("/{taskId}")
	public ResponseEntity<TaskDTO> getTaskDetails(@PathVariable long taskId) throws TaskManagerException {
		TaskDTO dto = service.getTask(taskId);
		return new ResponseEntity<TaskDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskDTO>> getAllTasks() throws TaskManagerException {
		return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/all/{employeeId}")
	public ResponseEntity<List<TaskDTO>> getAllTasksByEmployeeId(@PathVariable long employeeId) throws TaskManagerException {
		return new ResponseEntity<>(service.getTasksByEmployeeId(employeeId), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO task) throws TaskManagerException {
		TaskDTO dto = service.addTask(task);
		return new ResponseEntity<TaskDTO>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable long taskId, @RequestBody TaskDTO task) throws TaskManagerException {
		TaskDTO dto = service.updateTask(taskId, task);
		return new ResponseEntity<TaskDTO>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<Long> deleteTask(@PathVariable long taskId) throws TaskManagerException {
		long id = service.deleteTask(taskId);
		return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
	}
	
	
}








