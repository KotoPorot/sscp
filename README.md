# Dynamic JSON Transformer (sscp)

## 📌 Project Overview

This is a **pet project** created for educational purposes. It does not aim to solve global production tasks. Its main objective is to organize, consolidate, and structure my knowledge in modern Java backend development, as well as to practice designing flexible application architectures.

The primary focus of the application is implementing dynamic JSON data transformation using verification mechanisms and highly flexible configuration.

---

## 🛠 Tech Stack

The following technologies, frameworks, and tools were used during the development of this project:

* **Programming Language:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Security)
* **Databases & Migrations:** PostgreSQL / H2, Liquibase
* **ORM / Data Access:** Spring Data JPA, Hibernate
* **Testing:** JUnit 5, Spock Framework, Mockito
* **Build Tools:** Maven / Gradle

---

## 🚀 Core Skills & Concepts Learned

Throughout the development process, I dived deep into several crucial software engineering concepts and successfully implemented them in practice:

### 1. Advanced Spring Framework & SpEL
* **Custom SpEL Evaluation Context:** Learned how to create and configure a custom execution context for Spring Expression Language (SpEL), enabling secure and dynamic evaluation of JSON transformation rules.
* **Spring Security:** Configured a security layer to ensure reliable endpoint protection and resource access management.

### 2. REST API Design & Data Management
* **Architectural Patterns:** Practiced building a clean layered architecture (Controller -> Service -> Repository) and applying the DTO (Data Transfer Object) pattern to separate internal domain logic from the external API layer.
* **Spring Data JPA & Hibernate:** Configured entity mappings, managed database relationships, and focused on query efficiency.

### 3. Database Schema Version Control
* **Liquibase:** Mastered database schema management through database migrations. Learned how to write and structure `changelogs`, ensuring database reproducibility and consistency across different environments.

### 4. Testing Methodologies & Comparative Analysis
* **Multi-Framework Testing (JUnit vs. Spock):** Wrote comprehensive unit and integration tests using both **JUnit 5** and **Spock Framework**. This allowed me to deeply understand the differences between standard Java testing approaches and Groovy-driven BDD (Behavior-Driven Development), expanding my testing toolkit and adaptability.
* **Mocking:** Utilized Mockito and Spock's native mocking capabilities to isolate components, ensuring the high stability and reliability of the custom transformation logic.

---

## ⚙️ How to Run the Project Locally

1. Clone the repository:
   ```bash
   git clone [https://github.com/KotoPorot/sscp.git](https://github.com/KotoPorot/sscp.git)
