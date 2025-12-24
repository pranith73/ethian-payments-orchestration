\# Section 2 — Domain Model (Ethian)



This section defines the \*\*core domain vocabulary\*\* for Ethian (entities, IDs, value objects, aggregates, invariants, and domain events).

It is written to be \*\*beginner-friendly\*\* and also usable as a \*\*single source of truth\*\* for implementation.

## Contents

- [2.0 Why a Domain Model?](docs/section-2-domain-model/2.0-domain-model-why.md)
- [2.1 Core Domain Entities](docs/section-2-domain-model/2.1-core-domain-entities.md)
- [2.2 ER Diagram](docs/section-2-domain-model/2.2-er-diagram.md)
- [2.3 Value Objects](docs/section-2-domain-model/2.3-value-objects.md)
- [2.4 Aggregates & Invariants](docs/section-2-domain-model/2.4-aggregates-invariants.md)
- [2.5 Payment State Machine](docs/section-2-domain-model/2.5-payment-state-machine.md)
- [2.6 Invoice State Machine](docs/section-2-domain-model/2.6-invoice-state-machine.md)
- [2.7 Ledger Model (Double-Entry)](docs/section-2-domain-model/2.7-ledger-model-double-entry.md)
- [2.8 Invariants Summary Table](docs/section-2-domain-model/2.8-invariants-summary-table.md)
- [2.9 Domain Events Model](docs/section-2-domain-model/2.9-domain-events-model.md)
- [2.10 Serialization Rules](docs/section-2-domain-model/2.10-serialization-rules.md)
- [2.11 Beginner Examples](docs/section-2-domain-model/2.11-beginner-examples.md)
- [2.12 Interview Hooks](docs/section-2-domain-model/2.12-interview-hooks.md)


---



\## 2.0 Why a Domain Model?

\- What problems it solves

\- How it keeps microservices consistent

\- How we avoid “Stringly-typed” IDs and accidental coupling



📄 Details: \[2.0-domain-model-why](section-2-domain-model/2.0-domain-model-why.md)



---



\## 2.1 Core Domain Entities (Catalog)

This is the dictionary of domain objects Ethian uses.



📄 Details: \[2.1-core-domain-entities](section-2-domain-model/2.1-core-domain-entities.md)



---



\## 2.2 ER Diagram (Relationships)

The \*\*relationship truth\*\* between Merchant, Customer, Invoice, Payment, Settlement, LedgerEntry, Product, DomainEvent.



📄 Details: \[2.2-er-diagram](section-2-domain-model/2.2-er-diagram.md)



---



\## 2.3 Value Objects

Money, Currency, TimeInstant, BusinessDate (and why we use Value Objects).



📄 Details: \[2.3-value-objects](section-2-domain-model/2.3-value-objects.md)



---



\## 2.4 Aggregates \& Invariants

Aggregate roots + boundaries + invariants (rules we never break).



📄 Details: \[2.4-aggregates-invariants](section-2-domain-model/2.4-aggregates-invariants.md)



---



\## 2.5 Payment State Machine

Clear payment lifecycle states and transitions.



📄 Details: \[2.5-payment-state-machine](section-2-domain-model/2.5-payment-state-machine.md)



---



\## 2.6 Invoice State Machine

Invoice lifecycle states and transitions.



📄 Details: \[2.6-invoice-state-machine](section-2-domain-model/2.6-invoice-state-machine.md)



---



\## 2.7 Ledger Model (Double Entry)

How LedgerEntry works and why fintech needs this.



📄 Details: \[2.7-ledger-model-double-entry](section-2-domain-model/2.7-ledger-model-double-entry.md)



---



\## 2.8 Invariants Summary Table

A quick “rules cheat-sheet” of invariants by entity/aggregate.



📄 Details: \[2.8-invariants-summary-table](section-2-domain-model/2.8-invariants-summary-table.md)



---



\## 2.9 Domain Events Model

Event contract and what Ethian services publish/consume.



📄 Details: \[2.9-domain-events-model](section-2-domain-model/2.9-domain-events-model.md)



---



\## 2.10 Serialization Rules

Rules for JSON/event serialization so services stay compatible.



📄 Details: \[2.10-serialization-rules](section-2-domain-model/2.10-serialization-rules.md)



---



\## 2.11 Beginner Examples

Concrete examples: “Merchant issues invoice”, “Customer pays”, “Settlement happens”.



📄 Details: \[2.11-beginner-examples](section-2-domain-model/2.11-beginner-examples.md)



---



\## 2.12 Interview Hooks

How to explain this domain model in interviews (architect-style).



📄 Details: \[2.12-interview-hooks](section-2-domain-model/2.12-interview-hooks.md)



