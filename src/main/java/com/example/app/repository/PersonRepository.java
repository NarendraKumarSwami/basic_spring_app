package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.app.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	
	
	@Query("FROM Person p WHERE p.pId>:s  AND p.pId <= :end")
	public Optional<List<Person>>  findwithRange(@Param("s") Integer start,@Param("end") Integer end);	
	
	
	
	@Query("FROM Person p WHERE p.name LIKE :name%")
	public Optional<List<Person>> findPersonsByName(@Param("name")  String name);

}
