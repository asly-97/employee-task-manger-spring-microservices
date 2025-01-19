package com.taskmanager.employee.exception;

public class EmployeeNotFoundException extends TaskManagerException{

	public EmployeeNotFoundException() {
		super("Employee was not found with the given id");
	}
	
}
