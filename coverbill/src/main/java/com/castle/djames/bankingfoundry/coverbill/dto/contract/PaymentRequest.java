package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

public record PaymentRequest(@Valid PaymentSource source,
                             @Valid PaymentTarget target,
                             @Min(value = 1, message = "Amount must be greater than zero") BigDecimal amount,
                             Currency currency,
                             @Valid PaymentMode paymentMode) {
}
