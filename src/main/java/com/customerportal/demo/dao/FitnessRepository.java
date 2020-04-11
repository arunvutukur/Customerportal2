package com.customerportal.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.customerportal.demo.entity.fitness;

public interface FitnessRepository extends JpaRepository<fitness, Integer> {

}
