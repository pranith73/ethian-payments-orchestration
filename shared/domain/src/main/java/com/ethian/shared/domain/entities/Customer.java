package com.ethian.shared.domain.entities;

import java.util.Objects;

public final class Customer {

    private final CustomerId customerId;// as per Section 2.1: customerId (UUID)
    private final String emailOrPhone;
    private final String name;
    private final String billingAddress;
    private final String metadata;

    private Customer(CustomerId customerId, String emailOrPhone, String name, String billingAddress, String metadata) {
        this.customerId = Objects.requireNonNull(customerId, "customerId");
        this.emailOrPhone = requireNonBlank(emailOrPhone, "emailOrPhone");
        this.name = requireNonBlank(name, "name");
        this.billingAddress = requireNonBlank(billingAddress, "billingAddress");
        this.metadata = Objects.requireNonNullElse(metadata, "").trim();
    }

    public static Customer of(CustomerId customerId, String emailOrPhone, String name, String billingAddress, String metadata) {
        return new Customer(customerId, emailOrPhone, name, billingAddress, metadata);
    }

    public CustomerId customerId() { return customerId; }
    public String emailOrPhone() { return emailOrPhone; }
    public String name() { return name; }
    public String billingAddress() { return billingAddress; }
    public String metadata() { return metadata; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
