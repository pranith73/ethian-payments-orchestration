package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class ProductId {
    private final String value;

    private ProductId(String value) {
        this.value = value;
    }

    public static ProductId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ProductId cannot be null or blank");
        }
        return new ProductId(value.trim());
    }

    public static ProductId newId() {
        return new ProductId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId that = (ProductId) o;
        return value.equals(that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    @Override public String toString() {
        return value;
    }
}
