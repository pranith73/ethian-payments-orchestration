package com.ethian.shared.domain.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money {

    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_UP;

    private final long amountInMinorUnits;
    private final Currency currency;

    private Money(long amountInMinorUnits, Currency currency) {
        this.amountInMinorUnits = amountInMinorUnits;
        this.currency = currency;
    }

    public static Money ofMinor(long amountInMinorUnits, Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        return new Money(amountInMinorUnits, currency);
    }

    public long amountInMinorUnits() {
        return amountInMinorUnits;
    }

    public Currency currency() {
        return currency;
    }

    public Money add(Money other) {
        requireSameCurrency(other);
        return new Money(Math.addExact(this.amountInMinorUnits, other.amountInMinorUnits), currency);
    }

    public Money subtract(Money other) {
        requireSameCurrency(other);
        return new Money(Math.subtractExact(this.amountInMinorUnits, other.amountInMinorUnits), currency);
    }

    /**
     * Multiply by a factor (e.g., fee rate). Result stays in minor units.
     * Uses HALF_UP rounding as the default strategy.
     */
    public Money multiply(BigDecimal factor) {
        if (factor == null) {
            throw new IllegalArgumentException("Factor cannot be null");
        }
        BigDecimal result = BigDecimal.valueOf(amountInMinorUnits).multiply(factor);
        long rounded = result.setScale(0, DEFAULT_ROUNDING).longValueExact();
        return new Money(rounded, currency);
    }

    private void requireSameCurrency(Money other) {
        if (other == null) throw new IllegalArgumentException("Other money cannot be null");
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch: " + this.currency + " vs " + other.currency);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amountInMinorUnits == money.amountInMinorUnits && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountInMinorUnits, currency);
    }

    @Override
    public String toString() {
        return amountInMinorUnits + " " + currency;
    }
}
