package com.ethian.shared.domain.valueobjects;

import java.util.Objects;

public final class Currency {

    private final String code;
    private final int minorUnitDigits;

    private Currency(String code, int minorUnitDigits) {
        this.code = code;
        this.minorUnitDigits = minorUnitDigits;
    }

    public static Currency of(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Currency code cannot be null or blank");
        }

        String normalized = code.trim().toUpperCase();

        // Validates using Java's ISO 4217 registry
        java.util.Currency jdkCurrency;
        try {
            jdkCurrency = java.util.Currency.getInstance(normalized);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid currency code: " + normalized);
        }

        int digits = jdkCurrency.getDefaultFractionDigits(); // e.g., 2 for USD/INR
        return new Currency(normalized, digits);
    }

    public String code() {
        return code;
    }

    public int minorUnitDigits() {
        return minorUnitDigits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return code.equals(currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
