CREATE TABLE department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department_id BIGINT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES department(id)
);
