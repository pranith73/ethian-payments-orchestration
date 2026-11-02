**ETHIAN — Payments Orchestration Platform**

> Ethian proves a payment is processed exactly once and the ledger always balances, even under duplicate requests, redelivered messages, crashes mid-write, and concurrent updates.

Ethian is an educational, open-source payments orchestration platform designed to demonstrate how modern fintech payment systems are structured, documented, and evolved over time.

The project follows an architecture-first and documentation-driven approach, where system design, domain modeling, and decision records are established before full-scale implementation.

---

**Project Scope**

Ethian aims to model the complete lifecycle of a payments orchestration platform, including:

- Payment initiation and routing
- Domain-driven payment modeling
- Event-driven processing and settlement flows
- External payment gateway integrations
- Reliability, resilience, and observability concerns
- Security, error handling, and compliance-aware design

The platform is developed incrementally, with each phase documented and validated before proceeding to implementation.

---

**Technology Stack**  
*(Currently used up to Section 2)*

- Java 21 (LTS)
- Spring Boot 3.x (Spring Framework 6)
- Maven
- Git and GitHub

---

**Current Status**

Rebuilding toward v0.1.0. Design docs in `docs/`; earlier scaffold preserved at tag `v0-scaffold`.

---

**Build**

Requires JDK 21. From the repository root:

```bash
./mvnw verify
```

On Windows PowerShell use `.\mvnw.cmd verify`. This compiles every module, runs the tests, and checks formatting (Spotless), static analysis (SpotBugs) and coverage (JaCoCo report).

---

**Repository Structure**

```text
.
├─ services/                # Microservices (Spring Boot)
├─ shared/                  # Shared modules and domain abstractions
└─ docs/
   ├─ section-1-high-level-design/
   └─ section-2-domain-model/


```
---
**Planned Sections (Roadmap)**

Future documentation and implementation phases will include:

- API design and external contracts
- Controllers and DTO design
- Service-layer orchestration logic
- Event-driven payment processing
- External gateway integrations
- Rate limiting and resilience strategies
- Observability and monitoring
- Security and authorization model
- Error handling approach
- Testing strategy (unit and integration)

These sections will be added incrementally as the project evolves.

---

**License and Usage Intent**

This project is licensed under the MIT License (see `LICENSE`).

Ethian is developed as a non-commercial, open-source project intended for learning, architectural discussion, and collaborative experimentation. The software is provided "as is", without warranty of any kind, in accordance with the MIT License.

---