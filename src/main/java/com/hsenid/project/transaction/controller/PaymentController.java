package com.hsenid.project.transaction.controller;

import com.hsenid.project.transaction.model.PaymentInfo;
import com.hsenid.project.transaction.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @RequestMapping(value ="/send-money", method = RequestMethod.POST)
    public ResponseEntity<? extends String> transferBalance(@RequestBody PaymentInfo paymentInfo){
        paymentService.transferBalance(paymentInfo);
        return ResponseEntity.ok("Transaction successful. Transaction info :"+paymentInfo);
    }
}
