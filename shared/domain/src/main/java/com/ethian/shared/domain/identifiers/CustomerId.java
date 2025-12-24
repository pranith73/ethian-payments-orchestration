package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class CustomerId {
    private final String value;

    private CustomerId(String value) {
        this.value = value;
    }

    public static CustomerId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CustomerId cannot be null or blank");
        }
        return new CustomerId(value.trim());
    }

    public static CustomerId newId() {
        return new CustomerId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerId)) return false;
        CustomerId that = (CustomerId) o;
        return value.equals(that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    @Override public String toString() {
        return value;
    }
}
