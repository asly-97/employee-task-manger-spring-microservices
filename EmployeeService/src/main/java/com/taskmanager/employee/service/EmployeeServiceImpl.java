package com.taskmanager.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.employee.dto.EmployeeDTO;
import com.taskmanager.employee.entity.Employee;
import com.taskmanager.employee.exception.EmailIdAlreadyExistsException;
import com.taskmanager.employee.exception.EmployeeNotFoundException;
import com.taskmanager.employee.exception.TaskManagerException;
import com.taskmanager.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public EmployeeDTO getEmployee(long employeeId) throws TaskManagerException {
		Employee emp = repository.findById(employeeId)
				.orElseThrow(EmployeeNotFoundException::new);
		
		return EmployeeDTO.prepareDTO(emp);
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO emplyeeDto) throws TaskManagerException {
		
		Optional<Employee> opt = repository.findByEmail(emplyeeDto.getEmail());
		
		if(opt.isPresent()) {
			throw new EmailIdAlreadyExistsException();
		}
		
		Employee emp = EmployeeDTO.prepareEntity(emplyeeDto);
		
		repository.save(emp);
		
		return EmployeeDTO.prepareDTO(emp);
	}
	
	@Override
	public EmployeeDTO updateEmployee(long employeeId, EmployeeDTO emplyeeDto) throws TaskManagerException {
		
		Employee emp = repository.findById(employeeId)
		.orElseThrow(EmployeeNotFoundException::new);
		
		emp.setName(emplyeeDto.getName());
		emp.setDepartment(emplyeeDto.getDepartment());
		emp.setEmail(emplyeeDto.getEmail());

		repository.save(emp);
		
		return EmployeeDTO.prepareDTO(emp);
	}


	@Override
	public long deleteEmployee(long employeeId) throws TaskManagerException {
		repository.deleteById(employeeId);
		return employeeId;
	}



}
