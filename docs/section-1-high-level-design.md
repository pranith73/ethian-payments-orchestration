# Section 1 — High-Level Architecture (Ethian Payments Orchestration Platform)

This document provides the beginner-friendly, single-source explanation of Ethian’s high-level architecture.

## 1. Overview
Ethian is a Java 21 + Spring Boot–based **Payments Orchestration Platform** inspired by Stripe, Razorpay, and Adyen design principles.  
This section focuses on architectural clarity only — no code yet.

## 2. Goals of the System
- Unified orchestration for payment routing
- Modular service decomposition
- High availability and horizontal scaling
- Clear domain boundaries for future microservices

## 3. Core Architectural Concepts
- API Gateway
- Orchestration Layer
- Domain Services (User, Merchant, Payments, Ledger, Risk, Notifications)
- Database per service
- Event-driven extensions via Kafka (later sections)

## 4. High-Level Diagram (Placeholder)
*Diagram will be added later using Mermaid / PNG in Section 1 final pass.*

## 5. Why this Architecture?
- Enterprise-ready modular structure# Section 2 — Domain Model (Ethian Payments Platform)

This section documents the domain entities, relationships, and bounded contexts for Ethian.

## 1. Domain Overview
Ethian’s core domain revolves around:
- User
- Merchant
- Payment Intent
- Payment Method
- Transaction
- Ledger Entry
- Risk Event

## 2. Bounded Contexts
- **User Context** — manages authentication, onboarding, and identity
- **Merchant Context** — business accounts, KYC, fees
- **Payments Context** — payment creation, routing, retries
- **Ledger Context** — double-entry bookkeeping model
- **Risk Context** — fraud checks, velocity rules

## 3. Domain Diagram (Placeholder)
A clean class diagram will be generated later.

## 4. Persistence Strategy
- Java 21
- Spring Boot 3.x (added later as modules)
- Each bounded context will map to its own microservice

---

⚠ Note:  
Section 2 grows only when you start modeling domain entities.  
Right now it acts as a placeholder and structure guide.

- Easy to extend in future sections (3–13)
- Clean separation between domain model and orchestration
- Works well with Spring Boot microservices

---

⚠ Note:  
This file is intentionally simple.  
We will expand it only when you reach Section 1 officially.
