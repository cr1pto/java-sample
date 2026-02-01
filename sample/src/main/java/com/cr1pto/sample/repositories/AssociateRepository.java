package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cr1pto.sample.entities.Associate;

@Repository
public interface AssociateRepository extends CrudRepository<Associate, Long> {
    // Associate save(Associate Associate);

    // List<Associate> findAll();

    Associate findByLastName(String lastName);

    Associate findById(long id);

    // List<Associate> findByDescriptionContaining(String description);
}

// @Repository
// public interface IntegrationsRepository extends CrudRepository<Integration,
// Long> {
// Integration save(Integration integration);

// List<Integration> findAll();

// Integration findByName(String name);

// Integration findById(long id);

// List<Integration> findByDescriptionContaining(String description);
// }
