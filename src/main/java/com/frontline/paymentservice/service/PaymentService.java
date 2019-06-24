package com.frontline.paymentservice.service;

import com.frontline.paymentservice.model.Payment;
import com.frontline.paymentservice.repository.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(int id){
        return paymentRepository.getPaymentById(id);
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> getByCustomerId(String customerId) {
        return paymentRepository.findAllByCustomerId(customerId);
    }

    public List<String> getItemIdsByUserId(String customerId) {
        List<Payment> paymentList = paymentRepository.findAllByCustomerId(customerId);
        List<String> itemIdList = new ArrayList<>(paymentList.size());
        for (Payment payment : paymentList) {
            itemIdList.add(payment.getItemId());
        }
        return itemIdList;
    }

    public Payment addPayment(String customerId, String itemId, Integer quantity, double payment) {
        Payment paymentRecord = new Payment();
        paymentRecord.setCustomerId(customerId);
        paymentRecord.setItemId(itemId);
        paymentRecord.setQuantity(quantity);
        paymentRecord.setPayment(payment);
        return paymentRepository.saveAndFlush(paymentRecord);
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
