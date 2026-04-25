# School Admission System

This project is a school admission system built with Spring Boot, Kafka, and PostgreSQL. It consists of an admission service for handling student admission requests and a transport service for processing them via Kafka.

## Prerequisites

- Java 17
- Maven
- Docker and Docker Compose
- PostgreSQL (or use the provided Docker setup if available)

## Getting Started

### 1. Start Kafka using Docker Compose

Navigate to the root directory of the project and run the following command to start Kafka and Kafka UI:

```bash
docker-compose up -d
```

This will start:
- Kafka broker on `localhost:9092`
- Kafka UI on `http://localhost:8080` for monitoring

### 2. Run the Services

The project has two main services: `admission-service` and `transport-service`. Run them in separate terminals.

#### Admission Service

```bash
cd admission-service
mvn spring-boot:run
```

The admission service will start on `http://localhost:9999`.

#### Transport Service

```bash
cd transport-service
mvn spring-boot:run
```

The transport service will start on `http://localhost:8082`.

### 3. Use the School Admission API

To submit a student admission request, send a POST request to the admission service endpoint.

**Endpoint:** `POST http://localhost:9999/api/v1/school/admission-request`

**Request Body (JSON):**

```json
{
  "name": "John Doe",
  "age": 10,
  "address": "123 Main St, Anytown, USA",
  "uniformRequired": true
}
```

**Example using curl:**

```bash
curl -X POST http://localhost:9999/api/v1/school/admission-request \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "age": 10,
    "address": "123 Main St, Anytown, USA",
    "uniformRequired": true
  }'
```

**Response:**

A successful request will return a response like:

```json
{
  "message": "Admission request submitted successfully!",
  "success": true,
  "data": "ADM-12345678"
}
```

The admission request will be saved to the PostgreSQL database and published to the Kafka topic `admission_requests` for further processing by the transport service.

## Architecture

- **Admission Service**: Handles HTTP requests for admission submissions, saves data to PostgreSQL, and publishes events to Kafka.
- **Transport Service**: Consumes admission requests from Kafka and processes them (e.g., for transport arrangements).
- **Kafka**: Acts as the message broker for decoupling services.
- **PostgreSQL**: Stores admission request data.

## Monitoring

- Kafka UI: Access at `http://localhost:8080` to monitor Kafka topics and messages.</content>
<parameter name="filePath">/Users/amitkumar/codeyard/school-admission-system/README.md
