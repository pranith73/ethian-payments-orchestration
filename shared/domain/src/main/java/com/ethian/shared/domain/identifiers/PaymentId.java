package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class PaymentId {

    private final String value;

    private PaymentId(String value) {
        this.value = value;
    }

    public static PaymentId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("PaymentId cannot be null or blank");
        }
        return new PaymentId(value.trim());
    }

    public static PaymentId newId() {
        return new PaymentId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentId)) return false;
        PaymentId that = (PaymentId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
