package com.ethian.shared.domain.entities;

import com.ethian.shared.domain.identifiers.ProductId;
import com.ethian.shared.domain.valueobjects.Currency;
import com.ethian.shared.domain.valueobjects.Money;

import java.util.Objects;

public final class Product {

    private final ProductId productId; // as per Section 2.1: productId (UUID)
    private final String name;
    private final String description;
    private final Money price;
    private final Currency currency;

    private Product(ProductId productId, String name, String description, Money price, Currency currency) {
        this.productId = Objects.requireNonNull(productId, "productId");
        this.name = requireNonBlank(name, "name");
        this.description = Objects.requireNonNullElse(description, "").trim();
        this.price = Objects.requireNonNull(price, "price");
        this.currency = Objects.requireNonNull(currency, "currency");
    }

    public static Product of(ProductId productId, String name, String description, Money price, Currency currency) {
        return new Product(productId, name, description, price, currency);
    }

    public ProductId productId() { return productId; }
    public String name() { return name; }
    public String description() { return description; }
    public Money price() { return price; }
    public Currency currency() { return currency; }

    private static String requireNonBlank(String v, String name) {
        if (v == null || v.isBlank()) throw new IllegalArgumentException(name + " cannot be null/blank");
        return v.trim();
    }
}
