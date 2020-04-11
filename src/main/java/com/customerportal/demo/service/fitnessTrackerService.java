package com.customerportal.demo.service;

import java.util.List;

import com.customerportal.demo.entity.fitness;



public interface fitnessTrackerService {

	public List<fitness> findAll();
	
	public fitness findById(int theId);
	
	public void save(fitness thefitness_tracker);
	
	public void deleteById(int theId);
	
}
