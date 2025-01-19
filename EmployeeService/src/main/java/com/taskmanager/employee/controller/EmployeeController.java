package com.taskmanager.employee.controller;

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

import com.taskmanager.employee.dto.EmployeeDTO;
import com.taskmanager.employee.exception.TaskManagerException;
import com.taskmanager.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable long employeeId) throws TaskManagerException {
		EmployeeDTO dto = service.getEmployee(employeeId);
		return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO emp) throws TaskManagerException {
		EmployeeDTO dto = service.addEmployee(emp);
		return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long employeeId, @RequestBody EmployeeDTO emp) throws TaskManagerException {
		EmployeeDTO dto = service.updateEmployee(employeeId, emp);
		return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable long employeeId) throws TaskManagerException {
		long empId = service.deleteEmployee(employeeId);
		return new ResponseEntity<Long>(empId, HttpStatus.ACCEPTED);
	}
	
	
}








