package com.ethian.shared.domain.identifiers;

import java.util.Objects;
import java.util.UUID;

public final class WebhookEventId {

    private final String value;

    private WebhookEventId(String value) {
        this.value = value;
    }

    public static WebhookEventId of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("WebhookEventId cannot be null or blank");
        }
        return new WebhookEventId(value.trim());
    }

    public static WebhookEventId newId() {
        return new WebhookEventId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebhookEventId)) return false;
        WebhookEventId that = (WebhookEventId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
