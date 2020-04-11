package com.customerportal.demo.dao;

import java.util.List;

import com.customerportal.demo.entity.fitness_tracker;

public interface fitnessTrackerDAO {
	
	public List<fitness_tracker> findAll();
	
	public fitness_tracker findById(int theId);
	
	public void save(fitness_tracker userDetail);
	
	public void deleteById(int theId);
	
}
