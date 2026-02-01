package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cr1pto.sample.entities.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
