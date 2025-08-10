package com.cr1pto.samplewebapplication.springweb.data.entities;

public class NullIntegration extends Integration {
    public NullIntegration() {
        super();
        this.setActive(isActive());
        this.setName("New Integration");
        this.setDescription("New Integration Description");
        this.setLogo("stream data here");
        this.setUrl("http://localhost:8080/integrations/1");
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
