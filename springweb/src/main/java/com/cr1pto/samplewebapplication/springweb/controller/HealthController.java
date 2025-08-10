package com.cr1pto.samplewebapplication.springweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("health")
    public String health() {
        return "healthy";
    }
}
