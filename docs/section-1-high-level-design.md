# Section 1 — High-Level Architecture
**Ethian Payments Orchestration Platform**

This document provides a beginner-friendly, single-source explanation of the **high-level architecture** of the Ethian Payments Orchestration Platform.

This section intentionally focuses on **structure, boundaries, and responsibilities**, not implementation details.

---

## 1. Overview

Ethian is a **Java 21 + Spring Boot–based payments orchestration platform** designed to model how modern payment systems (such as Stripe, Razorpay, or Adyen) are architected internally.

At a high level, Ethian is responsible for:

- orchestrating payment workflows
- routing payment requests to appropriate services
- maintaining clear domain and service boundaries
- enabling future scalability and extensibility

This section explains *what exists* and *why it exists* at an architectural level.

---

## 2. Architectural Goals

The primary goals of Ethian’s architecture are:

- **Clear service boundaries**  
  Each major capability is isolated into its own service.

- **Independent service lifecycle**  
  Services can be started, stopped, and evolved independently.

- **Production-ready structure**  
  The layout mirrors real enterprise payment platforms.

- **Beginner-friendly progression**  
  The architecture grows gradually without premature complexity.

---

## 3. Core Architectural Concepts

Ethian follows a **service-oriented architecture** with the following core concepts:

- **Service-per-bounded-context**  
  Each core domain capability is implemented as a separate service.

- **Independent Spring Boot services**  
  Every service is a standalone Spring Boot application.

- **Clear internal vs external boundaries**  
  Internal operational endpoints are separated from business APIs.

- **Future-ready design**  
  Event-driven communication, gateways, and persistence strategies are added incrementally in later sections.

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
