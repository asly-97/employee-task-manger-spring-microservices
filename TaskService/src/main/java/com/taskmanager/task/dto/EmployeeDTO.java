package com.taskmanager.task.dto;

import java.time.LocalDateTime;

public class EmployeeDTO {
    private long id;
	private String name;
	private String email;
	private String department;
	private LocalDateTime createdAt;
	
	
	
	public EmployeeDTO() {
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
}
