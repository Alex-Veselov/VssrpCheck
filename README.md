# Phone sourcing service

This project is undertaken to develop phone sourcing service
REST-service for university work

## Goals

Develop two endpoint:
    - One with a computed field.
    - Another with data from multiple tables.
    - Ensure that endpoint return only the specified data fields.

## Endpoint

1. CRUD operation for each entity.

2. ...

3. ...

## Schema Description

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