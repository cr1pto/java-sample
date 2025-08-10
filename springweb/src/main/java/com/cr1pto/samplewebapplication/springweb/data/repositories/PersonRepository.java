package com.cr1pto.samplewebapplication.springweb.data.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cr1pto.sampleweb.data.entities.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {

    List<Person> findByLastName(@Param("name") String name);

}