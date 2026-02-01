package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Long> {

}