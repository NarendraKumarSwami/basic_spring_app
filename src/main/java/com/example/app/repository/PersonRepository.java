package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
