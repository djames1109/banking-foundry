package com.castle.djames.bankingfoundry.coverbill.dto.contract;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Currency {
    PHP;

    @JsonCreator
    public static Currency fromValue(String value) {
        for (var currency : values()) {
            if (currency.name().equalsIgnoreCase(value)) {
                return currency;
            }
        }
        throw new IllegalArgumentException("Invalid currency value: " + value);
    }
}
