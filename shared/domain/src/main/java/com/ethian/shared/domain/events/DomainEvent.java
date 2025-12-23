package com.ethian.shared.domain.events;

import com.ethian.shared.domain.valueobjects.TimeInstant;

public interface DomainEvent {

    String eventName();

    String eventVersion();

    TimeInstant occurredAt();
}
