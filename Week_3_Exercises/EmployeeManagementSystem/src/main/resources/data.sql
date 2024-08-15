INSERT INTO department (name, created_date, last_modified_date) VALUES
('HR', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('IT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO employee (name, email, department_id, created_date, last_modified_date) VALUES
('John Doe', 'john.doe@example.com', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jane Smith', 'jane.smith@example.com', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
