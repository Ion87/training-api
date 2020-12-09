CREATE TABLE users
(
    id   VARCHAR(36) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL CHECK (LEN(first_name) >= 3),
    last_name VARCHAR(50) NOT NULL CHECK (LEN(last_name) >= 3),
    email VARCHAR(70) NOT NULL UNIQUE CHECK (LEN(email) >= 10),
    username VARCHAR(50) NOT NULL UNIQUE CHECK (LEN(username) >= 3)
);