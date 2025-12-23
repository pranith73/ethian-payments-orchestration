package com.ethian.shared.domain.events.types;

import com.ethian.shared.domain.events.DomainEvent;
import com.ethian.shared.domain.events.EventVersion;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.identifiers.PaymentId;
import com.ethian.shared.domain.valueobjects.Money;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.Objects;

public final class PaymentAuthorizedEvent implements DomainEvent {

    private final PaymentId paymentId;
    private final MerchantId merchantId;
    private final Money amount;
    private final TimeInstant occurredAt;

    private PaymentAuthorizedEvent(PaymentId paymentId, MerchantId merchantId, Money amount, TimeInstant occurredAt) {
        this.paymentId = Objects.requireNonNull(paymentId, "paymentId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.amount = Objects.requireNonNull(amount, "amount");
        this.occurredAt = Objects.requireNonNull(occurredAt, "occurredAt");
    }

    public static PaymentAuthorizedEvent of(PaymentId paymentId, MerchantId merchantId, Money amount, TimeInstant occurredAt) {
        return new PaymentAuthorizedEvent(paymentId, merchantId, amount, occurredAt);
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public MerchantId merchantId() {
        return merchantId;
    }

    public Money amount() {
        return amount;
    }

    @Override
    public String eventName() {
        return "payment.authorized";
    }

    @Override
    public String eventVersion() {
        return EventVersion.V1;
    }

    @Override
    public TimeInstant occurredAt() {
        return occurredAt;
    }
}
