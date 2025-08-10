package com.cr1pto.samplewebapplication.springweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GreeterController {

    @GetMapping("greeting")
    public String greeting(Map<String, Object> model) {
        model.put("message", "hello Richard");
        return "greeting";
    }
}