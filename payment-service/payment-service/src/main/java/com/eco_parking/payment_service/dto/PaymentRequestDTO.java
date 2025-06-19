package com.eco_parking.payment_service.dto;

public class PaymentRequestDTO {
    private Long userId;
    private String vehicleId;
    private Double amount;

    public PaymentRequestDTO(Long userId, String vehicleId, Double amount) {
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.amount = amount;
    }

    public PaymentRequestDTO() {
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

    @Override
    public String toString() {
        return "PaymentRequestDTO{" +
                "userId='" + userId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
