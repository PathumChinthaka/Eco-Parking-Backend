package com.eco_parking.payment_service.dto;

import java.time.LocalDateTime;

public class PaymentReciptDTO {
    private String transactionRef;
    private String status;
    private Double amount;
    private String issuedTo;
    private LocalDateTime issuedAt;

    public PaymentReciptDTO(String transactionRef, String status, Double amount, String issuedTo, LocalDateTime issuedAt) {
        this.transactionRef = transactionRef;
        this.status = status;
        this.amount = amount;
        this.issuedTo = issuedTo;
        this.issuedAt = issuedAt;
    }

    public PaymentReciptDTO() {
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    @Override
    public String toString() {
        return "PaymentReciptDTO{" +
                "transactionRef='" + transactionRef + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", issuedTo='" + issuedTo + '\'' +
                ", issuedAt=" + issuedAt +
                '}';
    }
}
