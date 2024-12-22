# Project Information
| **Supervisor** | Dr. Nguyễn Bảo Ân |
|----------------|--------------------|
| **Student**    | Trần Minh Điền (Student ID: 110122050, DA22TTA) |


## Building & Apartment Management System

A comprehensive Spring Boot application for managing buildings, apartments, users, contracts and customers.

## 🚀 Features
- Building & Apartment management (CRUD operations)
- User account management
- Customer management
- Contract tracking
- Authentication and authorization
- Password encryption
- Environment separation using Spring profiles
- ...

## 🛠 Tech Stack
- Java 8
- Spring Boot 2.0.9
- Spring Data JPA
- MySQL Database
- ModelMapper
- Maven
- RESTful APIs

# API Documentation

## Introduction
This project is a RESTful API application built with **Spring Boot**. The API documentation is automated using **Swagger UI** via Springdoc OpenAPI.

## System Requirements
- **Java**: Version 1.8
- **Maven**: Version 3.x or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code

## Installation and Running the Application

### 1. Clone the Repository
Use the following commands to clone the repository:
```bash
git clone <git@github.com:diengbtvu/csn-da22tta-tranminhdien-restfulapi-springboot.git>
cd <csn-da22tta-tranminhdien-restfulapi-springboot>
```

### 2. Configuration
This project uses Spring profiles to separate environments (e.g., `dev`, `prod`). Create configuration files for each environment in `src/main/resources`:

#### Development Configuration (`application-dev.properties`)
```properties
datasource.url=jdbc:mysql://localhost:3306/dev_db
datasource.username=dev_user
datasource.password=dev_password
```

#### Production Configuration (`application-prod.properties`)
```properties
datasource.url=jdbc:mysql://localhost:3306/prod_db
datasource.username=prod_user
datasource.password=prod_password
```


### 3. Install Dependencies
Run the following command to install the required dependencies:
```bash
mvn clean install
```

### 4. Start the Application
Start the application using Maven:
```bash
mvn spring-boot:run
```

The application will run at:
```
http://localhost:8081
```

## Using the API
Access **Swagger UI** to view and test the APIs:
```
http://localhost:8081/swagger-ui.html
```


## Status Codes

| Code | Description |
|------|-------------|
| 200 | Success |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 500 | Server Error |



## 📝 Response Formats
- Success responses: HTTP 200 OK with data/empty body
- Create/Update responses: HTTP 200 OK
- Delete responses: HTTP 200 OK or 204 No Content
- Error responses: HTTP 404 Not Found or 500 Internal Server Error with error details

