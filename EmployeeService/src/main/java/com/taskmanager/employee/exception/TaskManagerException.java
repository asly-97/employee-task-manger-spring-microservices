package com.taskmanager.employee.exception;

import org.springframework.http.HttpStatus;

public class TaskManagerException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	protected HttpStatus httpStatus = HttpStatus.BAD_REQUEST;;
	private static final String defaultMessage = "Undefined TaskManagerExceptionException";

    public TaskManagerException() {
        super(defaultMessage);
    }

	public TaskManagerException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
	public TaskManagerException(String message) {
		super(message);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	

    
    
    
}
