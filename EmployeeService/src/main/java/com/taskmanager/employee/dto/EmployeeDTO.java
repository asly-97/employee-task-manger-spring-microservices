package com.taskmanager.employee.dto;

import java.time.LocalDateTime;

import com.taskmanager.employee.entity.Employee;

public class EmployeeDTO {
    private long id;
	private String name;
	private String email;
	private String department;
	private LocalDateTime createdAt;
	
	
	
	public EmployeeDTO() {
		super();
	}
	
	public static EmployeeDTO prepareDTO(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(emp.getId());
		dto.setName(emp.getName());
		dto.setDepartment(emp.getDepartment());
		dto.setEmail(emp.getEmail());
		dto.setCreatedAt(emp.getCreatedAt());
		
		return dto;
	}
	
	public static Employee prepareEntity(EmployeeDTO empDto) {
		Employee empEntity = new Employee();
		empEntity.setName(empDto.getName());
		empEntity.setDepartment(empDto.getDepartment());
		empEntity.setEmail(empDto.getEmail());
		
		return empEntity;
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
	
	
	
	
	
}
