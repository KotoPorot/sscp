--changeset rodionov:1
CREATE SCHEMA IF NOT EXISTS my_app_schema;

CREATE TABLE my_app_schema.users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE my_app_schema.test_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT NOT NULL
);

CREATE TABLE my_app_schema.test_entity_hobby (
    test_entity_id BIGINT NOT NULL,
    hobby VARCHAR(255),
    CONSTRAINT fk_test_entity FOREIGN KEY (test_entity_id) REFERENCES my_app_schema.test_entity(id)
);

CREATE TABLE my_app_schema.clients (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    date DATE,
    age INT NOT NULL
);