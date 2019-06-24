package com.frontline.paymentservice.repository;

import com.frontline.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment getPaymentById(int id);
    List<Payment> findAllByCustomerId(String customerId);
}
