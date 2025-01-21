package com.taskmanager.task.dto;

import java.time.LocalDateTime;

import com.taskmanager.task.entity.Task;
import com.taskmanager.task.entity.TaskStatus;

public class TaskDTO {
	
	private long taskId;

	private String title;
	
	private String description;
	
	private TaskStatus status;
	
	private long employeeId;
	
	private LocalDateTime createdAt;

	
	public static TaskDTO prepareDTO(Task task) {
		
		TaskDTO dto = new TaskDTO();
		
		dto.setTaskId(task.getTaskId());
		dto.setTitle(task.getTitle());
		dto.setDescription(task.getDescription());
		dto.setStatus(task.getStatus());
		dto.setEmployeeId(task.getEmployeeId());
		dto.setCreatedAt(task.getCreatedAt());
		
		return dto;
	}
	
	public static Task prepareEntity(TaskDTO dto) {
		
		Task task = new Task();
		
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		task.setEmployeeId(dto.getEmployeeId());
		
		return task;
	}

	public TaskDTO() {
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "TaskDTO [taskId=" + taskId + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", employeeId=" + employeeId + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
}

























