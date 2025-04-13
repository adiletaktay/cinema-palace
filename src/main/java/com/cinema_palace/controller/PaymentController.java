package com.cinema_palace.controller;

import com.cinema_palace.model.Card;
import com.cinema_palace.model.PaymentWrapper;
import com.cinema_palace.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("api/payment/card")
    public ResponseEntity<Boolean> cardValidation(@RequestBody Card cardDetails) {
        boolean validity = paymentService.cardValidation(cardDetails);
        return ResponseEntity.ok(validity);
    }

    @PostMapping("api/payment/proceed")
    public ResponseEntity<String> proceedPayment(@RequestBody PaymentWrapper payment) {
        if (paymentService.proceedPayment(payment))
            return ResponseEntity.status(HttpStatus.CREATED).body("Payment processed successfully.");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment processing failed.");
    }
}