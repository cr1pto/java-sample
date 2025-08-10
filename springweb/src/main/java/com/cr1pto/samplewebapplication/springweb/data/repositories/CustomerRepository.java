package com.cr1pto.samplewebapplication.springweb.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cr1pto.sampleweb.data.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}