package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import java.time.LocalDate;

public record PaymentMode(PaymentModeType type,
                          LocalDate startDate,
                          LocalDate endDate,
                          Frequency frequency) {
}
