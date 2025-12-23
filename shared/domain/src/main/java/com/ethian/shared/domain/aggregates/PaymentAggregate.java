package com.ethian.shared.domain.aggregates;

import com.ethian.shared.domain.entities.Payment;
import com.ethian.shared.domain.entities.support.PaymentState;
import com.ethian.shared.domain.identifiers.PaymentId;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.Objects;

public final class PaymentAggregate {

    private Payment payment;

    private PaymentAggregate(Payment payment) {
        this.payment = Objects.requireNonNull(payment, "payment");
    }

    public static PaymentAggregate from(Payment payment) {
        return new PaymentAggregate(payment);
    }

    public Payment snapshot() {
        return payment;
    }

    /* =======================
       DOMAIN INVARIANTS
       ======================= */

    /**
     * A payment can be authorized only once.
     */
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

    /**
     * Capture is allowed only after authorization.
     */
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

    /**
     * A failed payment is terminal.
     */
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
