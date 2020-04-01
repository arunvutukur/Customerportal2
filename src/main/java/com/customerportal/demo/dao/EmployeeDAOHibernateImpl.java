package com.customerportal.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customerportal.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	//Define field for entity manager
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
				
	
	@Override
	public List<Employee> findAll() {

		//get the current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		//create a query
		Query<Employee> theQuery =currentSession.createQuery("from Employee", Employee.class);
		//execute query and get result list
		List<Employee> employees =theQuery.getResultList();
		//return the results			
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		//Get the current hibernate session
		Session currentSession =entityManager.unwrap(Session.class);
		
		//Get the employee
		Employee theEmployee=
				currentSession.get(Employee.class, theId);
		//return the employee
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		//Get the current hibernate session
			Session currentSession =entityManager.unwrap(Session.class);
				
		//Save Employee
			currentSession.saveOrUpdate(theEmployee);
	}


	@Override
	public void deleteById(int theId) {
		
		//Get the current hibernate Session
		Session currentSession =entityManager.unwrap(Session.class);
		
		//Delete object with primary key
		Query theQuery=
				currentSession.createQuery("delete from Employee where id =:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
