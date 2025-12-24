package com.ethian.shared.domain.valueobjects;

import java.time.LocalDate;
import java.util.Objects;

public final class BusinessDate {

    private final LocalDate value;

    private BusinessDate(LocalDate value) {
        this.value = value;
    }

    public static BusinessDate of(LocalDate value) {
        if (value == null) {
            throw new IllegalArgumentException("BusinessDate cannot be null");
        }
        return new BusinessDate(value);
    }

    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessDate)) return false;
        BusinessDate that = (BusinessDate) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString(); // ISO-8601 date
    }
}
