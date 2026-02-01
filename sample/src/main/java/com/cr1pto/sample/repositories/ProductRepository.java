package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
