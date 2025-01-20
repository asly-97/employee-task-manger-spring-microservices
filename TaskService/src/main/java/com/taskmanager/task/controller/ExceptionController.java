package com.taskmanager.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.taskmanager.task.exception.TaskManagerException;


@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> main(Exception e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(TaskManagerException.class)
	public ResponseEntity<String> custom(TaskManagerException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
	}
	
	
	
	

}
