package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class InvoiceId {

    private final String value;

    private InvoiceId(String value) {
        this.value = value;
    }

    public static InvoiceId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("InvoiceId cannot be null or blank");
        }
        return new InvoiceId(value.trim());
    }

    public static InvoiceId newId() {
        return new InvoiceId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceId)) return false;
        InvoiceId that = (InvoiceId) o;
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
