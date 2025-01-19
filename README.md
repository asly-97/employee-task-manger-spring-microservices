# Employee Task Manager

A small microservice-based project to practice centralized configuration, service discovery, load balancing, resilience, and asynchronous communication using Spring Boot and Spring Cloud.

## Features
- **Employee Service**: CRUD operations for employees.
- **Task Service**: CRUD operations for tasks assigned to employees.
- **API Gateway**: Centralized routing using Spring Cloud Gateway.
- **Centralized Configuration**: Consul for configuration management.
- **Service Discovery**: Consul for service registry.
- **Load Balancing**: Spring Cloud Load Balancer.
- **Resilience**: Resilience4j for retries, fallbacks, and circuit breakers.
- **Async Communication**: RabbitMQ/Kafka for task status updates.

## Tech Stack
- Java, Spring Boot, Spring Cloud
- MySQL for database
- Consul for service discovery and configuration
- RabbitMQ/Kafka for messaging
- Resilience4j for fault tolerance

## Project Structure
```
com.yourname.employeetaskmanager
├── employee-service
├── task-service
├── gateway-service
```

## Database Schema
### Employees
| Column     | Type         |
|------------|--------------|
| id         | BIGINT (PK)  |
| name       | VARCHAR(100) |
| email      | VARCHAR(100) |
| department | VARCHAR(50)  |
| created_at | TIMESTAMP    |

### Tasks
| Column     | Type          |
|------------|---------------|
| id         | BIGINT (PK)   |
| title      | VARCHAR(100)  |
| description| TEXT          |
| status     | ENUM          |
| employee_id| BIGINT (FK)   |
| created_at | TIMESTAMP     |

## Setup
1. Clone the repository: `git clone <repo-url>`
2. Set up MySQL and create databases.
3. Configure Consul and messaging broker (RabbitMQ/Kafka).
4. Run each service using `mvn spring-boot:run`.
5. Access services via the API Gateway.

## Estimated Completion Time
~19 hours.
