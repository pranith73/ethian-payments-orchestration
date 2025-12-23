package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.entities.support.LedgerEntryType;
import com.ethian.shared.domain.identifiers.LedgerEntryId;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.identifiers.PaymentId;
import com.ethian.shared.domain.valueobjects.Money;
import com.ethian.shared.domain.valueobjects.TimeInstant;

import java.util.Objects;

public final class LedgerEntry {

    private final LedgerEntryId ledgerEntryId;
    private final PaymentId paymentId;
    private final MerchantId merchantId;

    private final LedgerEntryType type;
    private final Money amount;

    private final String account;
    private final TimeInstant timestamp;

    private LedgerEntry(LedgerEntryId ledgerEntryId,
                        PaymentId paymentId,
                        MerchantId merchantId,
                        LedgerEntryType type,
                        Money amount,
                        String account,
                        TimeInstant timestamp) {

        this.ledgerEntryId = Objects.requireNonNull(ledgerEntryId, "ledgerEntryId");
        this.paymentId = Objects.requireNonNull(paymentId, "paymentId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.type = Objects.requireNonNull(type, "type");
        this.amount = Objects.requireNonNull(amount, "amount");
        this.account = requireNonBlank(account, "account");
        this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
    }

    public static LedgerEntry of(LedgerEntryId ledgerEntryId,
                                 PaymentId paymentId,
                                 MerchantId merchantId,
                                 LedgerEntryType type,
                                 Money amount,
                                 String account,
                                 TimeInstant timestamp) {
        return new LedgerEntry(ledgerEntryId, paymentId, merchantId, type, amount, account, timestamp);
    }

    public LedgerEntryId ledgerEntryId() { return ledgerEntryId; }
    public PaymentId paymentId() { return paymentId; }
    public MerchantId merchantId() { return merchantId; }
    public LedgerEntryType type() { return type; }
    public Money amount() { return amount; }
    public String account() { return account; }
    public TimeInstant timestamp() { return timestamp; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
