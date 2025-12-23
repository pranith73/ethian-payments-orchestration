package com.ethian.shared.domain.aggregates;

import com.ethian.shared.domain.entities.Invoice;

import java.util.Objects;

/**
 * Section 2.4 - InvoiceAggregate
 * Consistency boundary for invoice status and totals.
 *
 * Owns:
 * - Invoice (root)
 */
public final class InvoiceAggregate {

    private Invoice invoice;

    private InvoiceAggregate(Invoice invoice) {
        this.invoice = Objects.requireNonNull(invoice, "invoice");
    }

    public static InvoiceAggregate from(Invoice invoice) {
        return new InvoiceAggregate(invoice);
    }

    public Invoice snapshot() {
        return invoice;
    }
}
