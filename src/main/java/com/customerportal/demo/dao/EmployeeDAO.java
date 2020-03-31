package com.customerportal.demo.dao;

import java.util.List;

import com.customerportal.demo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
}
