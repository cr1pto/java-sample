package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cr1pto.sample.entities.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

}