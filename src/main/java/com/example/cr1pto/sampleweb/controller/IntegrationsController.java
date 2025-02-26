package com.example.cr1pto.sampleweb.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cr1pto.sampleweb.data.entities.Integration;
import com.example.cr1pto.sampleweb.data.entities.NullIntegration;
import com.example.cr1pto.sampleweb.data.repositories.IntegrationsRepository;
import com.example.cr1pto.sampleweb.services.IntegrationsService;

@RestController
public class IntegrationsController {
    private IntegrationsService integrationsService;
    private IntegrationsRepository repository;

    public IntegrationsController(IntegrationsRepository repository) {
        super();
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/integrations")
    List<Integration> all() {
        return repository.findAll()
                .stream()
                .filter(Integration::isActive).toList();

    }
    // end::get-aggregate-root[]

    @PostMapping("/integrations")
    Integration newIntegration(@RequestBody Integration newIntegration) {
        // todo: refactor to use service
        if (newIntegration == null) {
            return new NullIntegration();
        }
        return integrationsService.save(newIntegration);
    }

    // Single item

    @GetMapping("/integrations/{id}")
    Integration one(@PathVariable Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @PutMapping("/integrations/{id}")
    Integration replaceIntegration(@RequestBody Integration newIntegration, @PathVariable Long id) {

        return repository.findById(id)
                .map(integration -> {
                    integration.setName(newIntegration.getName());
                    integration.setDescription(newIntegration.getDescription());
                    integration.setLogo(newIntegration.getLogo());
                    integration.setUrl(newIntegration.getUrl());
                    integration.setActive(newIntegration.isActive());
                    return repository.save(integration);
                })
                .orElseGet(() -> {
                    return repository.save(newIntegration);
                });
    }

    @DeleteMapping("/integrations/{id}")
    void deleteIntegration(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/integrations")
    void deleteAllintegrations() {
        repository.deleteAll();
    }
}
