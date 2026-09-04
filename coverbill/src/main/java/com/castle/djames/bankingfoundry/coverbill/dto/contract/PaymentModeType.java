package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentModeType {
    ONE_TIME("One-Time"),
    RECURRING("Recurring"),
    SCHEDULED("Scheduled");

    private final String value;

    public static PaymentModeType fromValue(String value) {
        for (PaymentModeType type : values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentModeType value: " + value);
    }
}
