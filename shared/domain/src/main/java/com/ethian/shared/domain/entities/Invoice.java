package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.entities.support.InvoiceStatus;
import com.ethian.shared.domain.identifiers.InvoiceId;
import com.ethian.shared.domain.identifiers.MerchantId;
import com.ethian.shared.domain.valueobjects.Currency;
import com.ethian.shared.domain.valueobjects.Money;

import java.util.Objects;

public final class Invoice {

    private final InvoiceId invoiceId;
    private final MerchantId merchantId;

    private final String customerId; // as per Section 2.1: customerId (UUID)
    private final String lineItems;  // simplified placeholder for now
    private final Money totalAmount;
    private final Currency currency;
    private final InvoiceStatus status;

    private Invoice(InvoiceId invoiceId,
                    MerchantId merchantId,
                    String customerId,
                    String lineItems,
                    Money totalAmount,
                    Currency currency,
                    InvoiceStatus status) {

        this.invoiceId = Objects.requireNonNull(invoiceId, "invoiceId");
        this.merchantId = Objects.requireNonNull(merchantId, "merchantId");
        this.customerId = requireNonBlank(customerId, "customerId");
        this.lineItems = Objects.requireNonNullElse(lineItems, "").trim();
        this.totalAmount = Objects.requireNonNull(totalAmount, "totalAmount");
        this.currency = Objects.requireNonNull(currency, "currency");
        this.status = Objects.requireNonNull(status, "status");
    }

    public static Invoice of(InvoiceId invoiceId,
                             MerchantId merchantId,
                             String customerId,
                             String lineItems,
                             Money totalAmount,
                             Currency currency,
                             InvoiceStatus status) {
        return new Invoice(invoiceId, merchantId, customerId, lineItems, totalAmount, currency, status);
    }

    public InvoiceId invoiceId() { return invoiceId; }
    public MerchantId merchantId() { return merchantId; }
    public String customerId() { return customerId; }
    public String lineItems() { return lineItems; }
    public Money totalAmount() { return totalAmount; }
    public Currency currency() { return currency; }
    public InvoiceStatus status() { return status; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
