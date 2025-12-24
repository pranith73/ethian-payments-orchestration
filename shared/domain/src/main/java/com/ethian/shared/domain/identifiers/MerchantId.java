package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class MerchantId {
    private final String value;

    private MerchantId(String value) {
        this.value = value;
    }

    public static MerchantId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("MerchantId cannot be null/blank");
        }
        return new MerchantId(value.trim());
    }

    public static MerchantId newId() {
        return new MerchantId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MerchantId)) return false;
        MerchantId that = (MerchantId) o;
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
