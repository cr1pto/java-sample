package com.example.cr1pto.sampleweb.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cr1pto.sampleweb.data.entities.Customer;
import com.example.cr1pto.sampleweb.data.repositories.CustomerRepository;
import com.example.cr1pto.sampleweb.services.CustomerService;

@RestController
public class CustomersController {

    private final CustomerRepository repository;
    private CustomerService customerService;

    public CustomersController(CustomerRepository customerRepository, CustomerService customerService) {
        this.repository = customerRepository;
        this.customerService = customerService;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    List<Customer> all() {
        return customerService.getCustomers();
    }
    // end::get-aggregate-root[]

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    // Single item

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) throws NotFoundException {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @PutMapping("/Customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setAddress1(newCustomer.getAddress1());
                    customer.setAddress2(newCustomer.getAddress2());
                    customer.setCity(newCustomer.getCity());
                    customer.setState(newCustomer.getState());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/customers")
    void deleteAllCustomers() {
        repository.deleteAll();
    }
}