package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class SettlementId {
    private final String value;

    private SettlementId(String value) {
        this.value = value;
    }

    public static SettlementId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("SettlementId cannot be null or blank");
        }
        return new SettlementId(value.trim());
    }

    public static SettlementId newId() {
        return new SettlementId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SettlementId)) return false;
        SettlementId that = (SettlementId) o;
        return value.equals(that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    @Override public String toString() {
        return value;
    }
}
