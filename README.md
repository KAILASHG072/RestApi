# REST API

This repository contains the code for a simple RESTful API built with Java Spring Boot. The API allows users to perform CRUD operations on a database of customers.

## Requirements
To run this project, you will need:
- Java JDK 11 or later
- Maven 3.6.0 or later
- MySQL server

## Installation
1. Clone the repository:
   ```
   git clone https://github.com/KAILASHG072/RestApi.git
   ```
2. Open the project directory in your terminal.
3. Create a new database in MySQL.
4. Configure the database connection details in the `application.properties` file located in `src/main/resources`.

## Endpoints
The API provides the following endpoints:

| Method | Endpoint                    | Description                          |
| ------ | --------------------------- | ------------------------------------ |
| GET    | /users                      | Get all customer in the database.    |
| GET    | /users/{username}           | Get an customer by ID.               | 
| GET    | /mechanics                  | Get all mechanics in the database.   |
| POST   | /users                      | Create a new customer.               |
| POST   | /mechanics                  | Create a new mechanics.              |
| PUT    | /{mechanic}/user/{username} | Assign a mechanics to any customer   |
| DELETE | /users/{id}                 | Delete an employee by ID.            |
| POST   | /files                      | upload a file/photo for use          |

## Usage
You can test the API using tools such as [Postman](https://www.postman.com/) or by sending HTTP requests using your preferred programming language.

For example, to create a new customer, you can send a POST request to http://localhost:8080/users with the following request body:
```
{
    "username": "ramesh",
    "password": "1234567890",
    "brand_name": "ramesh@example.com",
    "manufacturing_year": "2012",
    "model_name": 50000
}
```



## License
This project is licensed under the MIT License. See the LICENSE file for more information.
[![GitHub issues](https://img.shields.io/github/issues/{KAILASHG072}/{RestApi})] (https://github.com/{KAILASHG072}/{RestApi}/issues)

