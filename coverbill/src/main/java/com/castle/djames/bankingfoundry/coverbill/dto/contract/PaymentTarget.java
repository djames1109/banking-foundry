package com.castle.djames.bankingfoundry.coverbill.dto.contract;

public record PaymentTarget(String bank,
                            String productName,
                            String accountNumber,
                            String accountName) {
}
