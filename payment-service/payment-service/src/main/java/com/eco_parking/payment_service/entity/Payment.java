package com.eco_parking.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String vehicleId;
    private Double amount;
    private String status;
    private LocalDateTime timestamp;
    private String transactionRef;

    public Payment(Long id, Long userId, String vehicleId, Double amount, String status, LocalDateTime timestamp, String transactionRef) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
        this.transactionRef = transactionRef;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                ", transactionRef='" + transactionRef + '\'' +
                '}';
    }
}
