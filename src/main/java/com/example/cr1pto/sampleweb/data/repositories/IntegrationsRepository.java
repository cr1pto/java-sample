package com.example.cr1pto.sampleweb.data.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cr1pto.sampleweb.data.entities.Integration;

@Repository
public interface IntegrationsRepository extends CrudRepository<Integration, Long> {
    Integration save(Integration integration);

    List<Integration> findAll();

    Integration findByName(String name);

    Integration findById(long id);

    Integration findByDescriptionText(String textToFind);
}