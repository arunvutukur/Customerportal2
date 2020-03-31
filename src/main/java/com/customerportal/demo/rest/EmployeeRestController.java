package com.customerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerportal.demo.dao.EmployeeDAO;
import com.customerportal.demo.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
		// Quick and Dirty: Inject employee DAO
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {		
		employeeDAO =theEmployeeDAO;
	}
	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
	
	@GetMapping("/hello")
	public String HelloWorld() {
	
		return "Hello World";
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
		
}