CREATE TABLE roles
(
    id   VARCHAR(36) PRIMARY KEY,
    name VARCHAR(50) NOT NULL CHECK (LEN(name) >= 3)
);
