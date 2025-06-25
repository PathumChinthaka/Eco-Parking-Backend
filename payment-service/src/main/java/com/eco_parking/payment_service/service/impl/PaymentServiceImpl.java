package com.eco_parking.payment_service.service.impl;

import com.eco_parking.payment_service.dto.PaymentReciptDTO;
import com.eco_parking.payment_service.dto.PaymentRequestDTO;
import com.eco_parking.payment_service.entity.Payment;
import com.eco_parking.payment_service.repository.PaymentRepository;
import com.eco_parking.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private  final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentReciptDTO processPayment(PaymentRequestDTO paymentRequestDTO) {
        // Simulate payment logic
        String ref = UUID.randomUUID().toString();
        String status = Math.random() > 0.1 ? "SUCCESS" : "FAILED";

        Payment payment = new Payment();
        payment.setUserId(paymentRequestDTO.getUserId());
        payment.setVehicleId(paymentRequestDTO.getVehicleId());
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setStatus(status);
        payment.setTransactionRef(ref);
        payment.setTimestamp(LocalDateTime.now());

        paymentRepository.save(payment);

        return new PaymentReciptDTO(
                ref,
                status,
                paymentRequestDTO.getAmount(),
                paymentRequestDTO.getUserId().toString(),
                payment.getTimestamp()
        );
    }

    @Override
    public List<Payment> getListByUserId(Long userId) {
        List<Payment> payments = paymentRepository.findByUserId(userId);
        return payments;
    }
}
