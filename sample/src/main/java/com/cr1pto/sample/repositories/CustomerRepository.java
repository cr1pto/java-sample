package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
}
