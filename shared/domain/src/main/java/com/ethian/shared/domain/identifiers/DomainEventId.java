package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class DomainEventId {
    private final String value;

    private DomainEventId(String value) {
        this.value = value;
    }

    public static DomainEventId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("DomainEventId cannot be null or blank");
        }
        return new DomainEventId(value.trim());
    }

    public static DomainEventId newId() {
        return new DomainEventId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainEventId)) return false;
        DomainEventId that = (DomainEventId) o;
        return value.equals(that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    @Override public String toString() {
        return value;
    }
}
