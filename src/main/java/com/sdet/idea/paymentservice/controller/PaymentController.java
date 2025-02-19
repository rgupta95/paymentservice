package com.sdet.idea.paymentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sdet.idea.paymentservice.entity.Payment;
import com.sdet.idea.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {

        return service.doPayment(payment);
    }
    @GetMapping("/{orderId}")
public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) throws JsonProcessingException {

return service.findPaymentHistoryByOrderId(orderId);
}

}
