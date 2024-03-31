create DATABASE academytop;
use academytop;

create table Person (
id int primary key auto_increment,
name varchar(20),
surname varchar(20),
age int
);

insert into Person(name, surname, age)
VALUES
('John', 'Kennedy', 40),
('Frank', 'Sinatra', 45),
('Mickle', 'Jackson', 35);

DELETE FROM Person
WHERE age < 40;

-- DROP TABLE Person
-- SELECT * FROM Person
-- TRUNCATE Person