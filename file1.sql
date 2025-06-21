create database temp;

use temp;

CREATE TABLE student(
id INT PRIMARY KEY,
name VARCHAR(255)
);

INSERT INTO student VALUES(1,'Ali');

SELECT * FROM student;