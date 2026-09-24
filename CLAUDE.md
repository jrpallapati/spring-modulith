# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean install
./mvnw clean install -DskipTests

# Run
./mvnw spring-boot:run

# Test
./mvnw test
./mvnw test -Dtest=SpringModulithApplicationTests          # single class
./mvnw test -Dtest=SpringModulithApplicationTests#contextLoads  # single method
```

## Architecture

This is a **Spring Modulith** demo project — a modular monolith using Spring Boot 4.0.6 and Spring Modulith 2.0.6, running on Java 25+.

### Modulith Pattern

Spring Modulith enforces module boundaries by package structure. Each subdirectory under `org.pallapati.spring.modulith` is treated as an independent module. The test class verifies module structure at test time via:

```java
ApplicationModules.of(SpringModulithApplication.class).verify()
```

This call will fail if module boundaries are violated (e.g., one module directly instantiating another module's internal types).

### Module: `order`

The single current module lives under `org.pallapati.spring.modulith.order`:

- `Order` — JPA entity defined as a Java record; mapped to the `orders` table
- `controller/OrderManagement` — REST controller exposing CRUD endpoints
- `repository/OrderRepository` — package-private `JpaRepository`; not accessible outside this module

`OrderRepository` is package-private intentionally — this enforces the Spring Modulith rule that internal infrastructure types should not be exposed across module boundaries.

### Data Layer

- H2 in-memory database (runtime); schema is auto-created via `ddl-auto=create-drop`
- SQL logging enabled in `application.properties` (`spring.jpa.show-sql=true`)
- H2 Console is available for development-time database inspection

### Adding a New Module

Create a new top-level package under `org.pallapati.spring.modulith.<module-name>`. Keep internal types (repositories, services) package-private. Expose only public-facing types (domain objects, application services). Use Spring application events for cross-module communication rather than direct dependencies.

### Unit Tests
- When you make any code changes, create appropriate unit tests and make sure all unit tests run successfully.