package com.taskmanager.task.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taskmanager.task.dto.EmployeeDTO;

@FeignClient(name= "employee-service-client", url = "http://localhost:9000/api")
public interface EmployeeClient {
	
	@GetMapping("/employee/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable long id);

}
