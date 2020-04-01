package com.customerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerportal.demo.dao.EmployeeDAO;
import com.customerportal.demo.entity.Employee;
import com.customerportal.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//private EmployeeDAO employeeDAO;
		// Quick and Dirty: Inject employee DAO
//	@Autowired
//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {		
//		employeeDAO =theEmployeeDAO;
//	}
	//Refactored the code to use employee service
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {		
		employeeService =theEmployeeService;
	}
	
	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		//return employeeDAO.findAll();
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee =employeeService.findById(employeeId);
		
		if( theEmployee ==null) {
			throw new RuntimeException("the employee is not found" + employeeId);
		}
		
		return theEmployee;		
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
