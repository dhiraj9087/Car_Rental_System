# Car Rental System

## Description
The Car Rental System is a comprehensive solution designed using Java and Spring Boot, featuring secure authentication and efficient data management. The system provides RESTful APIs for managing cars, customers, and rentals, along with a robust JWT authentication mechanism to ensure secure access to resources.

## Features
- **RESTful APIs**: Architected a comprehensive car rental system using Java and Spring Boot.
- **JWT Authentication**: Established JWT authentication and refresh token mechanism for secure access.
- **Entity Relationships**: Designed and implemented entity relationships for Cars, Customers, and Rentals.
- **DTO Pattern**: Integrated DTO pattern, reducing data transfer payload by 40% and improving response times by 25%.

## Technologies Used
- Java
- Spring Boot
- JWT
- Object-oriented programming (OOP)

## Project Structure
org.example
├── auth
│   ├── JwtAuthFilter
│   ├── SecurityConfig
│   └── UserConfig
│
├── controller
│   ├── AuthController
│   ├── CarController
│   ├── CustomerController
│   ├── RentalController
│   └── TokenController
│
├── entities
│   ├── Car
│   ├── Customer
│   ├── RefreshToken
│   ├── Rental
│   ├── UserInfo
│   └── UserRole
│
├── model
│   └── UserInfoDto
│
├── repository
│   ├── CarRepository
│   ├── CustomerRepository
│   ├── RefreshTokenRepository
│   ├── RentalRepository
│   └── UserRepository
│
├── request
│   ├── AuthRequestDTO
│   ├── CarRequestDTO
│   ├── CustomerRequestDTO
│   ├── RefreshTokenRequestDTO
│   └── RentalRequestDTO
│
├── response
│   ├── CarResponseDTO
│   ├── CustomerResponseDTO
│   ├── JwtResponseDTO
│   └── RentalResponseDTO
│
├── service
│   ├── CarService
│   ├── CustomerService
│   ├── CustomUserDetails
│   ├── JwtService
│   ├── RefreshTokenService
│   ├── RentalService
│   └── UserDetailsServicelmpl
│
└── resources
└── application.properties
build.gradle
Copy
## Getting Started

### Prerequisites
- Java 11 or higher
- Spring Boot 2.5.4 or higher
- Gradle 6.8.3 or higher
- MySQL database

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/car-rental-project.git

2. Navigate to the project directory:
   ```bash
   cd car-rental-project

3. Build the project using Gradle:
   ```bash
   ./gradlew build

4. Configure the application.properties file with your database settings.

### Running the Application

1. Start the Spring Boot application:
   ```bash
   ./gradlew bootRun

2. Access the application at http://localhost:(9898).

### Usage

API Endpoints: The application exposes various RESTful endpoints for managing cars, customers, and rentals. You can use tools like Postman or cURL to interact with the APIs.


### License
This project is licensed under the MIT License - see the LICENSE file for details.
