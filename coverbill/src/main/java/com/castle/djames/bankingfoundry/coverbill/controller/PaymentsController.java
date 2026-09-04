package com.castle.djames.bankingfoundry.coverbill.controller;

import com.castle.djames.bankingfoundry.coverbill.dto.contract.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/payments")
@RestController
public class PaymentsController {

    @PostMapping("/submit")
    public ResponseEntity<?> submitPayment(@RequestBody @Validated PaymentRequest request) {
        log.info("Entering submitPayment. Request: {}", request);
        return ResponseEntity.ok("Payment submitted");
    }
}
