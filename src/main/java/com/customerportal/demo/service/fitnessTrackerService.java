package com.customerportal.demo.service;

import java.util.List;

import com.customerportal.demo.entity.fitness_tracker;



public interface fitnessTrackerService {

	public List<fitness_tracker> findAll();
	
	public fitness_tracker findById(int theId);
	
	public void save(fitness_tracker thefitness_tracker);
	
	public void deleteById(int theId);
	
}
