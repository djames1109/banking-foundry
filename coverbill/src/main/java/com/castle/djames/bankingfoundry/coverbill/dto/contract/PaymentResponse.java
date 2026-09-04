package com.castle.djames.bankingfoundry.coverbill.dto.contract;

public record PaymentResponse(String referenceId,
                              PaymentStatus status,
                              String message) {
}
