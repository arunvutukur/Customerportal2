package com.customerportal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.customerportal.demo.entity.fitness;
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
	public List<fitness> findAll() {
		
		return fitnessTrackerDAO.findAll();
	}

	@Override
	public fitness findById(int theId) {
	
		return fitnessTrackerDAO.findById(theId);
	}

	@Override
	public void save(fitness thefitness_tracker) {
	
		fitnessTrackerDAO.save(thefitness_tracker);
	}

	@Override
	public void deleteById(int theId) {
	
		fitnessTrackerDAO.deleteById(theId);
		
	}
	

}
