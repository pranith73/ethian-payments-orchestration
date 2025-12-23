package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class LedgerEntryId {

    private final String value;

    private LedgerEntryId(String value) {
        this.value = value;
    }

    public static LedgerEntryId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("LedgerEntryId cannot be null or blank");
        }
        return new LedgerEntryId(value.trim());
    }

    public static LedgerEntryId newId() {
        return new LedgerEntryId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LedgerEntryId)) return false;
        LedgerEntryId that = (LedgerEntryId) o;
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
