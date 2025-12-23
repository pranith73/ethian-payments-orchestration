package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.entities.support.PaymentState;
import com.ethian.shared.domain.identifiers.InvoiceId;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.identifiers.PaymentId;
import com.ethian.shared.domain.valueobjects.Currency;
import com.ethian.shared.domain.valueobjects.Money;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.Objects;

public final class Payment {

    private final PaymentId paymentId;
    private final InvoiceId invoiceId;
    private final MerchantId merchantId;

    private final Money amount;
    private final Currency currency;

    private final String processor;
    private final PaymentState state;

    private final String idempotencyKey;
    private final TimeInstant createdAt;
    private final TimeInstant updatedAt;

    private Payment(PaymentId paymentId,
                    InvoiceId invoiceId,
                    MerchantId merchantId,
                    Money amount,
                    Currency currency,
                    String processor,
                    PaymentState state,
                    String idempotencyKey,
                    TimeInstant createdAt,
                    TimeInstant updatedAt) {

        this.paymentId = Objects.requireNonNull(paymentId, "paymentId");
        this.invoiceId = Objects.requireNonNull(invoiceId, "invoiceId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.amount = Objects.requireNonNull(amount, "amount");
        this.currency = Objects.requireNonNull(currency, "currency");
        this.processor = requireNonBlank(processor, "processor");
        this.state = Objects.requireNonNull(state, "state");
        this.idempotencyKey = requireNonBlank(idempotencyKey, "idempotencyKey");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt");
    }

    public static Payment of(PaymentId paymentId,
                             InvoiceId invoiceId,
                             MerchantId merchantId,
                             Money amount,
                             Currency currency,
                             String processor,
                             PaymentState state,
                             String idempotencyKey,
                             TimeInstant createdAt,
                             TimeInstant updatedAt) {
        return new Payment(paymentId, invoiceId, merchantId, amount, currency, processor, state, idempotencyKey, createdAt, updatedAt);
    }

    public PaymentId paymentId() { return paymentId; }
    public InvoiceId invoiceId() { return invoiceId; }
    public MerchantId merchantId() { return merchantId; }
    public Money amount() { return amount; }
    public Currency currency() { return currency; }
    public String processor() { return processor; }
    public PaymentState state() { return state; }
    public String idempotencyKey() { return idempotencyKey; }
    public TimeInstant createdAt() { return createdAt; }
    public TimeInstant updatedAt() { return updatedAt; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
