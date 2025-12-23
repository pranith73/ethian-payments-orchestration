package com.ethian.shared.domain.events.types;

import com.ethian.shared.domain.events.DomainEvent;
import com.ethian.shared.domain.identifiers.DomainEventId;
import com.ethian.shared.domain.identifiers.InvoiceId;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.identifiers.PaymentId;
import com.ethian.shared.domain.valueobjects.Money;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.Objects;

/**
 * Domain Event: Payment Authorized
 *
 * Section 2 requirement:
 * - eventId
 * - type
 * - entityId (PaymentId)
 * - payload (minimal info)
 * - occurredAt
 */
public final class PaymentAuthorizedEvent implements DomainEvent {

    private final DomainEventId eventId;
    private final PaymentId paymentId;
    private final MerchantId merchantId;
    private final InvoiceId invoiceId;
    private final Money amount;
    private final TimeInstant occurredAt;

    private PaymentAuthorizedEvent(DomainEventId eventId,
                                  PaymentId paymentId,
                                  MerchantId merchantId,
                                  InvoiceId invoiceId,
                                  Money amount,
                                  TimeInstant occurredAt) {
        this.eventId = Objects.requireNonNull(eventId, "eventId");
        this.paymentId = Objects.requireNonNull(paymentId, "paymentId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.invoiceId = Objects.requireNonNull(invoiceId, "invoiceId");
        this.amount = Objects.requireNonNull(amount, "amount");
        this.occurredAt = Objects.requireNonNull(occurredAt, "occurredAt");
    }

    public static PaymentAuthorizedEvent of(DomainEventId eventId,
                                           PaymentId paymentId,
                                           MerchantId merchantId,
                                           InvoiceId invoiceId,
                                           Money amount,
                                           TimeInstant occurredAt) {
        return new PaymentAuthorizedEvent(eventId, paymentId, merchantId, invoiceId, amount, occurredAt);
    }

    @Override
    public DomainEventId eventId() {
        return eventId;
    }

    @Override
    public String type() {
        return "PAYMENT_AUTHORIZED";
    }

    @Override
    public String entityId() {
        return paymentId.value();
    }

    @Override
    public String payload() {
        return "merchantId=" + merchantId.value()
                + ",invoiceId=" + invoiceId.value()
                + ",amount=" + amount.amount()
                + ",currency=" + amount.currency();
    }

    @Override
    public TimeInstant occurredAt() {
        return occurredAt;
    }

    // Optional domain convenience accessors
    public PaymentId paymentId() { return paymentId; }
    public MerchantId merchantId() { return merchantId; }
    public InvoiceId invoiceId() { return invoiceId; }
    public Money amount() { return amount; }
}
