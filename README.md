# Spring Boot CRUD API - Student Management System

## Overview

This Spring Boot application implements a simple CRUD (Create, Read, Update, Delete) API for managing students. The application uses a MySQL database to store student information and exposes RESTful endpoints to perform CRUD operations.

## Table of Contents

- Prerequisites
- Setup and Run
- Implemented CRUD Operations
- Testing with Postman

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- Java JDK 8 or later
- Maven
- MySQL

## Setup and Run

Certainly! If you are using Eclipse IDE to run the Spring Boot application, you can follow these steps:

Before proceeding, ensure that you have the following installed:

- [Java JDK 8 or later](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Eclipse IDE](https://www.eclipse.org/downloads/)

### Setup and Run in Eclipse IDE

1. Clone the Repository:

   ```bash
   git clone https://github.com/prajyotjagtap/StudentCRUDOperations
   ```

2. Import Project into Eclipse:

   Open Eclipse IDE and import the project.

   - File > Import > Existing Maven Projects
   - Browse to the project directory and select it.
   - Click Finish.

3. Update `application.properties`:

   Open the `src/main/resources/application.properties` file and update the MySQL database configuration:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
   spring.datasource.username=[your-username]
   spring.datasource.password=[your-password]
   ```

   Replace `[your-username]` and `[your-password]` with your MySQL username and password.

4. Run the Application:

   Right-click on the project in Eclipse, then select `Run As` > `Spring Boot App`.

   Alternatively, you can use the Maven commands:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The Spring Boot application will start, and you can access it at `http://localhost:8080`.


## Implemented CRUD Operations

### 1. Create a Student

- Endpoint: POST /api/students
- Request Body:
    json
    {
      "studName": "John Doe",
      "studAge": 20,
      "studCourse": "Computer Science",
      "studCon": "9876543210"
    }
  
- Response:
    json
    {
      "studId": 1,
      "studName": "John Doe",
      "studAge": 20,
      "studCourse": "Computer Science",
      "studCon": "9876543210"
    }
    

### 2. Read All Students

- Endpoint: GET /api/students
- Response:
    ```json
    [
      {
        "studId": 1,
        "studName": "John Doe",
        "studAge": 20,
        "studCourse": "Computer Science",
        "studCon": "9876543210"
      },
      // ... other students
    ]
    ```

### 3. Read Student by ID

- Endpoint: GET /api/students/{studId}
- Response:
    ```json
    {
      "studId": 1,
      "studName": "John Doe",
      "studAge": 20,
      "studCourse": "Computer Science",
      "studCon": "9876543210"
    }
    ```

### 4. Update a Student

- Endpoint: PUT /api/students/{studId}
- Request Body:
    ```json
    {
      "studName": "Updated Name",
      "studAge": 21,
      "studCourse": "Updated Course",
      "studCon": "9876543210"
    }
    ```
- Response:
    ```json
    {
      "studId": 1,
      "studName": "Updated Name",
      "studAge": 21,
      "studCourse": "Updated Course",
      "studCon": "9876543210"
    }
    ```

### 5. Delete a Student

- Endpoint: DELETE /api/students/{studId}
- Response:
    ```
    Student with ID 1 deleted.
    ```

## Testing with Postman

To test the implemented CRUD operations, you can use Postman or any other API testing tool. Here are sample requests:

1. Create a Student:
    - Method: POST
    - URL: http://localhost:8080/api/students
    - Body (raw JSON):
        ```json
        {
          "studName": "John Doe",
          "studAge": 20,
          "studCourse": "Computer Science",
          "studCon": "9876543210"
        }
        ```
2. Read All Students:
    - Method: GET
    - URL: http://localhost:8080/api/students

3. Read Student by ID:
    - Method: GET
    - URL: http://localhost:8080/api/students/{studId}
    - Replace `{studId}` with the actual student ID.

4. Update a Student:
    - Method: PUT
    - URL: http://localhost:8080/api/students/{studId}
    - Replace `{studId}` with the actual student ID.
    - Body (raw JSON):
        ```json
        {
          "studName": "Updated Name",
          "studAge": 21,
          "studCourse": "Updated Course",
          "studCon": "9876543210"
        }
        ```

5. Delete a Student:
    - Method: DELETE
    - URL: `http://localhost:8080/api/students/{studId}`
    - Replace `{studId}` with the actual student ID.
