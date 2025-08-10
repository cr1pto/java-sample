package com.cr1pto.samplewebapplication.springweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

    @GetMapping("people")
    public String getPeople() {

        return "greeting";
    }
}