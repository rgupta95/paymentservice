package com.sdet.idea.paymentservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdet.idea.paymentservice.entity.Payment;
import com.sdet.idea.paymentservice.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    public PaymentRepository repository;
    private Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public Payment doPayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        logger.info("Payment Service request: {}", new ObjectMapper().writeValueAsString(payment));

        return repository.save(payment);
    }
    public String paymentProcessing(){
        //api should be 3rd party payment gateway ( paypal , payTm)
        return new Random().nextBoolean()?"success": "false";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) throws JsonProcessingException {
        Payment payment = repository.findByOrderId(orderId);
        logger.info("Payment Service request: {}", new ObjectMapper().writeValueAsString(payment));


        return payment;
    }
}
