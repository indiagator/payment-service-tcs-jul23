package com.example.paymentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController
{
    Logger logger = LoggerFactory.getLogger(MainRestController.class);
    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("save/payment")
    public ResponseEntity<String> initiatePayment(@RequestBody Payment payment)
    {
        logger.info("new payment saved");
        //Payment payment = new Payment();
        //payment.setId(String.valueOf((int)(Math.random()*1000000)));
        //payment.setOrderid(orderid);
        //payment.setOfferid(offerid);
        //payment.setStatus("DUE");
        paymentRepository.save(payment);
        return new ResponseEntity<>("new payment initiated", HttpStatus.OK);
    }

    @GetMapping("get/greeting")
    public ResponseEntity<String> getGreeting()
    {
        return new ResponseEntity<>("this is the payments service",HttpStatus.OK);
    }

}
