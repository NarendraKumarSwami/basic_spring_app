package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	
	
	@Query("FROM Person p WHERE p.pId>:start  AND p.pId <= :end")
	public Optional<List<Person>>  findwithRange(Integer start, Integer end);	

}
