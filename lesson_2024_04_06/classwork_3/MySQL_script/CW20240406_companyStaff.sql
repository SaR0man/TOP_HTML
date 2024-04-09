CREATE DATABASE CW20240406_CompanyStaff;
USE CW20240406_CompanyStaff;

CREATE TABLE Products (
ID INT PRIMARY KEY AUTO_INCREMENT,
ProductName VARCHAR(50),
Price DECIMAL(10, 2)
);

INSERT INTO Products (ProductName, Price) VALUES
('Potato', 60),
('Tomatoes', 45),
('Carrot', 75);

-- DROP TABLE Products;
-- SELECT * FROM Products;
-- TRUNCATE Products;