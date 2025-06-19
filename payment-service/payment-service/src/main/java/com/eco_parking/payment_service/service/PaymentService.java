package com.eco_parking.payment_service.service;

import com.eco_parking.payment_service.dto.PaymentReciptDTO;
import com.eco_parking.payment_service.dto.PaymentRequestDTO;
import com.eco_parking.payment_service.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PaymentService {
    PaymentReciptDTO processPayment(PaymentRequestDTO paymentRequestDTO);
    List<Payment> getListByUserId(Long userId);
}
