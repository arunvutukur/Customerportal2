package com.customerportal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.customerportal.demo.entity.fitness_tracker;
import  com.customerportal.demo.dao.fitnessTrackerDAO;


@Repository
public class fitnessTrackerserviceImpl implements fitnessTrackerService {

	
	private fitnessTrackerDAO fitnessTrackerDAO;
	
	@Autowired
	public fitnessTrackerserviceImpl(fitnessTrackerDAO thefitnessTrackerDAO) {
	
		fitnessTrackerDAO = thefitnessTrackerDAO;
	}	
	
	public fitnessTrackerserviceImpl() {
		
	}

	@Override
	public List<fitness_tracker> findAll() {
		
		return fitnessTrackerDAO.findAll();
	}

	@Override
	public fitness_tracker findById(int theId) {
	
		return fitnessTrackerDAO.findById(theId);
	}

	@Override
	public void save(fitness_tracker thefitness_tracker) {
	
		fitnessTrackerDAO.save(thefitness_tracker);
	}

	@Override
	public void deleteById(int theId) {
	
		fitnessTrackerDAO.deleteById(theId);
		
	}

//	@Override
//	@Transactional
//	public List<Employee> findAll() {
//	
//		return employeeDAO.findAll();
//	}
//
//	@Override
//	@Transactional
//	public Employee findById(int theId) {
//	
//		return employeeDAO.findById(theId);
//	}
//
//	@Override
//	@Transactional
//	public void save(Employee theEmployee) {
//		employeeDAO.save(theEmployee);
//		
//	}
//
//	@Override
//	@Transactional
//	public void deleteById(int theId) {
//		employeeDAO.deleteById(theId);
//		
//	}
	
	
	
	

}
