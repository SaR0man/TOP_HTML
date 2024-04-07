CREATE DATABASE CompanyStaff;
USE CompanyStaff;

------

CREATE TABLE Staff (
ID INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20),
Surname VARCHAR(20),
Position VARCHAR(20),
Salary INT
);

INSERT INTO Staff (Name, Surname, Position, Salary) VALUES
('John', 'Doe', 'Manager', 60000),
('Jane', 'Smith', 'Sales Associate', 45000),
('Michael', 'Johnson', 'Software Engineer', 75000),
('Emily', 'Williams', 'HR Specialist', 50000),
('David', 'Brown', 'Financial Analyst', 65000);

-- DROP TABLE Staff;
-- SELECT * FROM Staff;
-- TRUNCATE Staff;