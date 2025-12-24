package com.ethian.shared.domain.aggregates;

import com.ethian.shared.domain.entities.LedgerEntry;
import com.ethian.shared.domain.entities.Payment;
import com.ethian.shared.domain.entities.support.PaymentState;
import com.ethian.shared.domain.events.DomainEvent;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Section 2.4 - PaymentAggregate
 * Consistency boundary for payment lifecycle and related records.
 *
 * Owns:
 * - Payment (root)
 * - LedgerEntries (append-only)
 * - DomainEvents (append-only)
 */
public final class PaymentAggregate {

    private Payment payment;

    private final List<LedgerEntry> ledgerEntries = new ArrayList<>();
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    private PaymentAggregate(Payment payment) {
        this.payment = Objects.requireNonNull(payment, "payment");
    }

    public static PaymentAggregate from(Payment payment) {
        return new PaymentAggregate(payment);
    }

    public Payment snapshot() {
        return payment;
    }

    public List<LedgerEntry> ledgerEntries() {
        return Collections.unmodifiableList(ledgerEntries);
    }

    public List<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void appendLedgerEntry(LedgerEntry entry) {
        ledgerEntries.add(Objects.requireNonNull(entry, "entry"));
    }

    public void appendDomainEvent(DomainEvent event) {
        domainEvents.add(Objects.requireNonNull(event, "event"));
    }

    // --------------------
    // Invariants / transitions
    // --------------------

    public void authorize(TimeInstant when) {
        requireState(PaymentState.INITIATED);

        payment = Payment.of(
                payment.paymentId(),
                payment.invoiceId(),
                payment.merchantId(),
                payment.amount(),
                payment.currency(),
                payment.processor(),
                PaymentState.AUTHORIZED,
                payment.idempotencyKey(),
                payment.createdAt(),
                when
        );
    }

    public void capture(TimeInstant when) {
        requireState(PaymentState.AUTHORIZED);

        payment = Payment.of(
                payment.paymentId(),
                payment.invoiceId(),
                payment.merchantId(),
                payment.amount(),
                payment.currency(),
                payment.processor(),
                PaymentState.CAPTURED,
                payment.idempotencyKey(),
                payment.createdAt(),
                when
        );
    }

    public void fail(TimeInstant when) {
        if (payment.state() == PaymentState.SETTLED) {
            throw new IllegalStateException("Cannot fail a settled payment");
        }

        payment = Payment.of(
                payment.paymentId(),
                payment.invoiceId(),
                payment.merchantId(),
                payment.amount(),
                payment.currency(),
                payment.processor(),
                PaymentState.FAILED,
                payment.idempotencyKey(),
                payment.createdAt(),
                when
        );
    }

    private void requireState(PaymentState expected) {
        if (payment.state() != expected) {
            throw new IllegalStateException(
                    "Invalid state transition. Expected " + expected + " but was " + payment.state()
            );
        }
    }
}
