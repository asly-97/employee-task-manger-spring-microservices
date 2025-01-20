package com.taskmanager.task.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

enum TaskStatus{
	PENDING,
	IN_PROGRESS,
	COMPLETED
}

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskId;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	private String description;
	
	private TaskStatus status = TaskStatus.PENDING;
	
	@Column(nullable = false)
	private long employeeId;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	public Task() {
	}

	public Task(long taskId, String title, String description, TaskStatus status, long employeeId,
			LocalDateTime createdAt) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.employeeId = employeeId;
		this.createdAt = createdAt;
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
		return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", employeeId=" + employeeId + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
	
	

}


















