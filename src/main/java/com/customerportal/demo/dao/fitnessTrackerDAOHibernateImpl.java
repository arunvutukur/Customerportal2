package com.customerportal.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.customerportal.demo.entity.fitness_tracker;

@Repository
public class fitnessTrackerDAOHibernateImpl implements fitnessTrackerDAO {

	
	//Define field for entity manager
	private EntityManager entityManager;
	
	@Autowired
	public fitnessTrackerDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
				
	
	@Override
	public List<fitness_tracker> findAll() {

		//get the current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		//create a query
		Query<fitness_tracker> theQuery =currentSession.createQuery("from fitness_tracker", fitness_tracker.class);
		//execute query and get result list
		List<fitness_tracker> employees =theQuery.getResultList();
		//return the results			
		return employees;
	}


	@Override
	public fitness_tracker findById(int theId) {
		//Get the current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		
		//Get the employee
		fitness_tracker thefitness_tracker=
				currentSession.get(fitness_tracker.class, theId);
		
		//return the employee
		return thefitness_tracker;
	}


	@Override
	public void save(fitness_tracker thefitness_tracker) {
		//Get the current hibernate session
			Session currentSession =entityManager.unwrap(Session.class);
				
		//Save Employee
			currentSession.saveOrUpdate(thefitness_tracker);
	}


	@Override
	public void deleteById(int theId) {
		
		//Get the current hibernate Session
		Session currentSession =entityManager.unwrap(Session.class);
		
		//Delete object with primary key
		Query theQuery=
				currentSession.createQuery("delete from fitness_tracker where id =:fitness_trackerId");
		theQuery.setParameter("fitness_trackerId", theId);
		
		theQuery.executeUpdate();
	}

}
