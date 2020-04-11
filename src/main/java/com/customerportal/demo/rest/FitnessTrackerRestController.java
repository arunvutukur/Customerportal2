package com.customerportal.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerportal.demo.entity.Employee;
import com.customerportal.demo.entity.fitness;
import com.customerportal.demo.service.fitnessTrackerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class FitnessTrackerRestController {
	
	private fitnessTrackerService fitnessTrackerService;

	//Refactored the code to use employee service
	@Autowired
	public FitnessTrackerRestController(fitnessTrackerService thefitnessTrackerService) {	
		
		fitnessTrackerService =thefitnessTrackerService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
			
			// get employees from db
		List<fitness> thefitness = fitnessTrackerService.findAll();
			
			// add to the spring model
		theModel.addAttribute("employees", thefitness);
			
		return "food/list-fooditems";
	}
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/food")
//	public List<fitness> findAll(){
//
//		return fitnessTrackerService.findAll();
//	}	
//	@GetMapping("/food/{foodId}")
//	public fitness getEmployee(@PathVariable int foodId) {
//		
//		fitness thefitness_tracker =fitnessTrackerService.findById(foodId);
//		
//		if( thefitness_tracker ==null) {
//			throw new RuntimeException("the employee is not found " + foodId);
//		}
//		
//		return thefitness_tracker;		
//	}
//
//
//	
//	
//	@GetMapping("/hello")
//	public String HelloWorld() {
//	
//		return "Hello World";
//	}
//	
//	@GetMapping("/")
//	public String index() {
//		return "Greetings from Spring Boot!";
//	}
//		
}
