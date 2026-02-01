package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
