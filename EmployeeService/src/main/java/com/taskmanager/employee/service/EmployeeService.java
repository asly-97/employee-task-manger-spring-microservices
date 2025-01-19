package com.taskmanager.employee.service;

import com.taskmanager.employee.dto.EmployeeDTO;
import com.taskmanager.employee.exception.TaskManagerException;

public interface EmployeeService {
	
	public EmployeeDTO getEmployee(long employeeId) throws TaskManagerException;
	
	public EmployeeDTO addEmployee(EmployeeDTO emplyeeDto) throws TaskManagerException;
	
	public EmployeeDTO updateEmployee(long employeeId, EmployeeDTO emplyeeDto) throws TaskManagerException;
	
	public long deleteEmployee(long employeeId) throws TaskManagerException;

}
