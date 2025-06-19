package com.eco_parking.payment_service.controller;

import com.eco_parking.payment_service.dto.PaymentReciptDTO;
import com.eco_parking.payment_service.dto.PaymentRequestDTO;
import com.eco_parking.payment_service.entity.Payment;
import com.eco_parking.payment_service.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = {"*"})
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentReciptDTO> pay(@RequestBody PaymentRequestDTO request) {
        PaymentReciptDTO receipt = paymentService.processPayment(request);
        return ResponseEntity.ok(receipt);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Payment>> history(@PathVariable Long userId) {
        return ResponseEntity.ok(paymentService.getListByUserId(userId));
    }
}
