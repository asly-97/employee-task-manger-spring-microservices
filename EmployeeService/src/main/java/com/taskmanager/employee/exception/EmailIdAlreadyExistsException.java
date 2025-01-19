package com.taskmanager.employee.exception;

public class EmailIdAlreadyExistsException extends TaskManagerException{

	public EmailIdAlreadyExistsException() {
		super("Email Id Already Exists");
	}

}
