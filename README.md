# Phone sourcing service

---

## About

This project is undertaken to develop phone sourcing service
REST-service for university work

## Goals

Develop two endpoint:
    - One with a computed field.
    - Another with data from multiple tables.
    - Ensure that endpoint return only the specified data fields.

## Endpoint

1. CRUD operation for each entity.

2. To get the total cost of all orders of one user:
    - The user id is passed as a parameter

3. To get the complete order information:
    - The order id is passed as a parameter

## Database Description

### Tables

1. Users:
    - ID
    - Name
    - Contact Information

2. Phones:
    - ID
    - Brand
    - Model
    - Price
    - Description
    - Availability

3. Orders:
    - ID
    - User ID
    - Phone ID
    - Quantity
    - Total Price
    - Posting Date

### Table Relationships

- Relationship between User and Order: One-to-many.
- Relationship between Phone and Order: One-to-many.

## Example command to run


#### Windows

```
set SPRING_DATASOURCE_USERNAME="database-username"
set SPRING_DATASOURCE_PASSWORD="database-password"
set SERVER_SSL_KEY_STORE_PASSWORD="ssl-key-password"
java -jar target\phone-sourcing-service-1.0.0-SNAPSHOT.jar
```

#### Linux

```
SPRING_DATASOURCE_USERNAME="database-username"   \
SPRING_DATASOURCE_PASSWORD="database-password"   \
SERVER_SSL_KEY_STORE_PASSWORD="ssl-key-password" \
java -jar target/phone-sourcing-service-1.0.0-SNAPSHOT.jar
```