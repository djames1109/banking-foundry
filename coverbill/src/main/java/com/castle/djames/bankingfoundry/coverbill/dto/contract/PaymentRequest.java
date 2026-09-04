package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import java.math.BigDecimal;

public record PaymentRequest(PaymentSource source,
                             PaymentTarget target,
                             BigDecimal amount,
                             Currency currency,
                             PaymentMode paymentMode) {
}
