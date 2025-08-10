package com.cr1pto.samplewebapplication.springweb.interfaces;

import java.util.List;

import com.example.cr1pto.sampleweb.data.entities.Customer;

public interface SimpleCustomerService {
    List<Customer> getCustomers();
}
