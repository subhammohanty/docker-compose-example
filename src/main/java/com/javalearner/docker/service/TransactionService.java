package com.javalearner.docker.service;


import com.javalearner.docker.entity.Payment;
import com.javalearner.docker.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment addPayment(Payment payment){
        payment.setId(UUID.randomUUID().toString().split("-")[0]);
        return paymentRepository.save(payment);
    }

    public List<Payment> viewAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment viewPayment(String transactionId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(transactionId);
        return optionalPayment.orElseThrow(() -> new RuntimeException("Payment with transaction ID " + transactionId + " not found"));
    }
}
