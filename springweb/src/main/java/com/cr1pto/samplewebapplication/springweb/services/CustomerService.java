package com.cr1pto.samplewebapplication.springweb.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cr1pto.sampleweb.data.entities.Customer;
import com.example.cr1pto.sampleweb.data.repositories.CustomerRepository;
import com.example.cr1pto.sampleweb.interfaces.SimpleCustomerService;

@Service
public class CustomerService implements SimpleCustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return ((Collection<Customer>) customerRepository.findAll()).stream().toList();
    }
}
