package com.cr1pto.sample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StoreController {
    @GetMapping("stores")
    public String getStores() {
        return new String();
    }
    
}
