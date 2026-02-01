package com.cr1pto.sample.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cr1pto.sample.requests.CustomerRequest;
import com.cr1pto.sample.responses.CustomersResponse;



@RestController
public class CustomersController {
    


    @GetMapping("customers")
    public CustomersResponse getMethodName() {
        return new CustomersResponse();
    }

    @PostMapping("customers")
    @ResponseBody
    public ResponseEntity<CustomersResponse> createNewCustomers(@RequestBody CustomerRequest request) {
        
        CustomersResponse result = new CustomersResponse();
        
        return ResponseEntity.created(URI.create("/customers/" + "")).body(result);
    }
    
    
}
