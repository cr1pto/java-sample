package com.cr1pto.samplewebapplication.springweb.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.cr1pto.sampleweb.data.entities.Integration;
import com.example.cr1pto.sampleweb.data.repositories.IntegrationsRepository;

@Service
public class IntegrationsService {
    private IntegrationsRepository integrationsRepository;

    public IntegrationsService(IntegrationsRepository integrationsRepository) {
        super();
        this.integrationsRepository = integrationsRepository;
    }

    public Integration save(Integration integration) {
        if (integration == null)
            throw new IllegalArgumentException("Integration cannot be null");
        if (integration.getName() == null || integration.getName().isEmpty())
            throw new IllegalArgumentException("Integration name cannot be null or empty");

        return integrationsRepository.save(integration);
    }

    public Integration getIntegrationById(long id) {
        return integrationsRepository.findById(id);
    }

    public List<Integration> getAllActiveIntegrations() {
        return integrationsRepository.findAll().stream()
                .filter(Integration::isActive).toList();
    }

    public Integration getIntegrationByName(String name) {
        return integrationsRepository.findByName(name);
    }

    public List<Integration> getIntegrationByDescription(String description) {
        return integrationsRepository.findByDescriptionContaining(description);
    }
}
