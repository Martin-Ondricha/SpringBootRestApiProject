# SpringBootRestApiProject



## Technologies:
- Java
- Spring Boot
- PostgreSQL
- Maven
- Postman
- REST API
- Hibernate

## Getting Started

To run this project locally, make sure you have Java(SpringBoot) with your preferred IDE for Java development, Maven, and PostgreSQL installed.
###  Recommended dependencies
 Ensure the following dependencies are included in your project:
 - Lombok
 - Spring Web
 - Spring Data JPA
 - PostgreSQL Driver

   You can add these dependencies to your `pom.xml` file or use your preferred build tool.

### Configuration

When configuring `spring.jpa.hibernate.ddl-auto`, you can use one of the following options:

- `'create'`: Create new tables, dropping existing tables if necessary.
- `'update'`: Update the existing schema, retaining data.
- `'create-drop'`: Create and then drop the tables at the end of the session.

Adjust the following properties in your `application.properties` file according to your preferences:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

## How the API works :

This project presents a robust REST API designed for managing user data. The API revolves around five user examples, each characterized by essential properties: `id`, `name`, `age`, `country`, and `email`. It's crucial to emphasize that each user is uniquely identified by their individual `id` and `email`.

Here's a brief overview of user properties and important constraints:

- **`id`:** A unique identifier assigned to each user. Must have a positive value.

- **`name`:** The name of the user.

- **`age`:** The age of the user, restricted to a range of 0 to 130.

- **`country`:** The country to which the user belongs.

- **`email`:** A unique email address associated with the user.

Additionally, note the following constraints:

- Users cannot have null fields; all properties are required.

- Age must be between 0 and 130.

- Id must have a positive value.
  If incorrect values are provided, the API will respond with error exceptions.

 ## Postman testing
 ### 1. **GET Request - Retrieve User by ID**
- **Endpoint:** `http://localhost:8080/user?id=5`
- **Method:** GET
- **Description:** Retrieve user information by providing the user ID.
- **Expected Response:**
  ```json
  {
      "id": 5,
      "name": "Martin",
      "age": 30,
      "country": "Slovakia",
      "email": "mato@email.com"
  }
 ### 2. **DELETE Request - Delete User by ID**
  - **Endpoint:** `http://localhost:8080/user?id=5`
- **Method:** DELETE
- **Description:** Delete the user with the provided ID.
- **Expected Response:**


    "message": "You deleted account with id: 5"

  
 ### 3. **POST Request - Add New User**
  - **Endpoint:** `http://localhost:8080`
- **Method:** POST
- **Description:** Add a new user with the provided information.
- **Expected Response:**
 ```json
{
    "id": 555,
    "name": "Martin",
    "age": 30,
    "country": "Slovakia",
    "email": "test@email.com"
}
 ```
 ### 4. **PUT Request - Update User by ID**
  - **Endpoint:** ` http://localhost:8080/user?id=5`
- **Method:** PUT
- **Description:**Update the user information with the provided data.
- **Request Body:**
 ```json
{
    "id": 5,
    "name": "Updated Martin",
    "age": 31,
    "country": "Updated Slovakia",
    "email": "updated_mato@email.com"
}
 ```
- **Expected Response:**

    "message": "User updated successfully"


  
