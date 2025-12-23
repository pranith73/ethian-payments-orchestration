package com.ethian.shared.domain.valueobjects;

import java.time.Instant;
import java.util.Objects;

public final class TimeInstant {

    private final Instant value;

    private TimeInstant(Instant value) {
        this.value = value;
    }

    public static TimeInstant of(Instant value) {
        if (value == null) {
            throw new IllegalArgumentException("TimeInstant cannot be null");
        }
        return new TimeInstant(value);
    }

    public static TimeInstant now() {
        return new TimeInstant(Instant.now());
    }

    public Instant value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeInstant)) return false;
        TimeInstant that = (TimeInstant) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString(); // ISO-8601 UTC
    }
}
