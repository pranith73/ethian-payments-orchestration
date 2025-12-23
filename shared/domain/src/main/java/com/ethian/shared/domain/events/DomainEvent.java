package com.ethian.shared.domain.events;

import com.ethian.shared.domain.identifiers.DomainEventId;
import com.ethian.shared.domain.valueobjects.TimeInstant;

/**
 * Section 2 Domain Model - Domain Events
 *
 * Minimal event contract:
 * - eventId: unique ID for the event instance
 * - type: event type name (e.g., PAYMENT_AUTHORIZED)
 * - entityId: the primary entity identifier related to this event (e.g., PaymentId.value())
 * - payload: minimal business payload as a string (kept simple at Section 2)
 * - occurredAt: time event occurred
 */
public interface DomainEvent {

    DomainEventId eventId();

    String type();

    String entityId();

    String payload();

    TimeInstant occurredAt();
}
