package com.javalearner.docker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalearner.docker.entity.Payment;
import com.javalearner.docker.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/payment")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) throws JsonProcessingException {
        log.info("TransactionController::addPayment input request {} ", new ObjectMapper().writeValueAsString(payment));
        Payment addedPayment = transactionService.addPayment(payment);
        return new ResponseEntity<>(addedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> viewAllPayments(){
        List<Payment> payments = transactionService.viewAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/payment/{transactionId}")
    public ResponseEntity<Payment> viewPayment(@PathVariable String transactionId) {
        Payment payment = transactionService.viewPayment(transactionId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
