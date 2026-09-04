package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Frequency {
    WEEKLY,
    MONTHLY,
    QUARTERLY,
    YEARLY;

    @JsonCreator
    public static Frequency fromValue(String value) {
        for (Frequency frequency : values()) {
            if (frequency.name().equalsIgnoreCase(value)) {
                return frequency;
            }
        }
        throw new IllegalArgumentException("Invalid frequency value: " + value);
    }
}
