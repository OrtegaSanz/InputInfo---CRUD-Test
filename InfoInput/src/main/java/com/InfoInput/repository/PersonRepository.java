package com.InfoInput.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.InfoInput.model.person;

public interface PersonRepository extends Repository<person, Integer>{
	List<person> findAll();
	person findById(Integer Id);
	void save(person person);
	void delete(person person);
}
