package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentModeType {
    ONE_TIME("One-Time"),
    RECURRING("Recurring"),
    SCHEDULED("Scheduled");

    private final String value;

    @JsonCreator
    public static PaymentModeType fromValue(String value) {
        for (PaymentModeType type : values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentModeType value: " + value);
    }
}
