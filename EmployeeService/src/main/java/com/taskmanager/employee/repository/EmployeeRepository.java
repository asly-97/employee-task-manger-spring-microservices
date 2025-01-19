package com.taskmanager.employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.employee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	Optional<Employee> findByEmail(String email);

}
