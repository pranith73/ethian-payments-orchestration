# Section 1 — High-Level Architecture
**Ethian Payments Orchestration Platform**

This document provides a beginner-friendly, single-source explanation of the **high-level architecture** of the Ethian Payments Orchestration Platform.

This section focuses on **structure, boundaries, and responsibilities**, not implementation details.

---

## 1. Overview

Ethian is a **Java 21 + Spring Boot–based payments orchestration platform** designed to model how modern payment systems (such as Stripe, Razorpay, or Adyen) are architected internally.

At a high level, Ethian is responsible for:

- orchestrating payment workflows
- routing payment requests across services
- enforcing clear domain and service boundaries
- enabling scalability and future extensibility

This section explains *what exists* and *why it exists* at an architectural level.

---

## 2. Architectural Goals

The primary goals of Ethian’s architecture are:

- **Clear service boundaries**  
  Each major capability is isolated into its own service.

- **Independent service lifecycle**  
  Services can be started, stopped, deployed, and evolved independently.

- **Production-ready structure**  
  The layout mirrors real-world enterprise payment platforms.

- **Beginner-friendly progression**  
  The architecture grows incrementally without premature complexity.

---

## 3. Core Architectural Concepts

Ethian follows a **service-oriented architecture** with these core concepts:

- **Service-per-bounded-context**  
  Each core business capability is implemented as a separate service.

- **Independent Spring Boot applications**  
  Every service is a standalone Spring Boot application.

- **Clear internal vs external boundaries**  
  Operational endpoints are separated from business APIs.

- **Future-ready design**  
  Event-driven communication, gateways, and persistence strategies are introduced incrementally in later sections.

---

## 4. Services Layout

All runtime services live under the `/services` directory at the repository root.

```text
services/
 ├── merchant-service
 ├── payment-service
 ├── ledger-service
 ├── settlement-service
 ├── invoice-service
 └── webhook-service
```

Each folder represents a **fully independent Spring Boot service** with its own lifecycle.

---

## 5. Service Responsibilities

The table below defines **clear ownership and responsibility boundaries** at a high level.

| Service            | Primary Responsibility                              | Data Ownership                         | API Exposure |
|--------------------|-----------------------------------------------------|----------------------------------------|--------------|
| merchant-service   | Manages merchant identity and configuration         | Merchant profiles and settings         | External + Internal |
| payment-service    | Orchestrates payment creation and state transitions | Payment intent and payment state       | External + Internal |
| invoice-service    | Generates invoices related to payments              | Invoice records                        | Internal |
| ledger-service     | Maintains immutable financial records               | Ledger entries (debits and credits)    | Internal |
| settlement-service | Handles settlement and payout workflows             | Settlement batches and status          | Internal |
| webhook-service    | Delivers outbound events to external systems        | Webhook delivery state                 | External |

At this stage, responsibilities are **conceptual**. Detailed domain rules and schemas are introduced in **Section 2 — Domain Model**.

---

## 6. High-Level Payment Flow (Happy Path)

The following describes the **happy-path flow** for creating a payment, focusing only on **service interaction**, not internal logic.

1. A client or merchant initiates a payment request.
2. The request is received by the **merchant-service** for merchant validation and context.
3. The **payment-service** creates a new payment intent and owns orchestration.
4. The **invoice-service** generates an invoice for the payment if required.
5. The **ledger-service** records provisional financial entries.
6. The **payment-service** updates the payment state based on processing outcome.
7. The **settlement-service** prepares settlement data for downstream payout.
8. The **webhook-service** dispatches relevant events to external systems.

This flow establishes **clear orchestration ownership** while keeping services loosely coupled.

---

## 7. Non-Functional Architecture Considerations

Ethian’s architecture accounts for the following non-functional concerns at a high level:

- **Scalability**  
  Each service can scale independently based on load.

- **Idempotency**  
  Payment-related operations are designed to be safely retried.

- **Timeouts and retries**  
  Inter-service communication anticipates partial failures.

- **Observability**  
  Each service exposes internal operational endpoints for health checks.

- **Security baseline**  
  Internal endpoints are separated from external-facing APIs.

These concerns are refined and implemented incrementally in later sections.

---

## 8. Architecture Diagram Placeholders

The following diagrams will be added in later phases:

- **System Context Diagram**  
  Shows Ethian’s interaction with external actors and systems.

- **Service Interaction Diagram**  
  Visualizes communication paths between internal services.

Placeholders are defined here to preserve architectural intent without premature detail.

---

## Section 1 Summary

By the end of this section, the reader should understand:

- what services exist in Ethian
- why each service exists
- how responsibilities are divided
- how a payment flows across services at a high level

Detailed domain models, entities, and relationships are introduced next in  
**Section 2 — Domain Model**.
