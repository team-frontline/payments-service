package com.frontline.paymentservice.service;

import com.frontline.paymentservice.model.Payment;
import com.frontline.paymentservice.repository.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(int id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }


    public Payment addPayment(Payment payment) {
        double price = payment.getPrice();
        int quantity = payment.getQuantity();
        payment.setPayment(price * quantity);
        return paymentRepository.saveAndFlush(payment);
    }

    public Payment deletePayment(int id) {
        Payment payment = paymentRepository.getPaymentById(id);
        paymentRepository.delete(payment);
        return payment;
    }

    public Payment updatePayment(int id, Payment payment) {
        Payment existingPayment = paymentRepository.getPaymentById(id);
        BeanUtils.copyProperties(payment, existingPayment);
        return paymentRepository.saveAndFlush(existingPayment);
    }
}
