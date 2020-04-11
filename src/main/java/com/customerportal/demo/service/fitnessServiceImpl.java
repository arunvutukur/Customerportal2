package com.customerportal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customerportal.demo.entity.fitness;
import com.customerportal.demo.dao.FitnessRepository;



@Repository
public class fitnessServiceImpl implements fitnessTrackerService {

	
	private FitnessRepository fitnessRepository;
	
	//private fitnessTrackerDAO fitnessTrackerDAO;
	
	@Autowired
	public fitnessServiceImpl(FitnessRepository thefitnessRepository) {
	
		fitnessRepository = thefitnessRepository;
	}	
	
	public fitnessServiceImpl() {
		
	}

	@Override
	public List<fitness> findAll() {
		
		return fitnessRepository.findAll();
	}

	@Override
	public fitness findById(int theId) {
	
		Optional<fitness> result = fitnessRepository.findById(theId);
		
		fitness thefitness =null;
		
		if(result.isPresent()) {
			
			thefitness =result.get();
		}else {
			
			throw new RuntimeException("Did not find fitness id- " + theId);
		}
				
		return thefitness;	
	}

	@Override
	public void save(fitness thefitness_tracker) {

		fitnessRepository.save(thefitness_tracker);
	}

	@Override
	public void deleteById(int theId) {
	
		fitnessRepository.deleteById(theId);
		
	}
	

}
