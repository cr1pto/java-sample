package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {

}