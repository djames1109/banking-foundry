package com.castle.djames.bankingfoundry.coverbill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1/payments")
@RestController
public class PaymentsController {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        log.info("Test endpoint called");
        return ResponseEntity.ok("Hello World");
    }
}
