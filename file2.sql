-- Creating the Worker table with essential employee details
CREATE TABLE Worker(
    WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- Unique ID for each worker (auto-incremented)
    FIRST_NAME CHAR(25),                               -- First name of the worker the argument here for char means it will only store till 25 rest it will truncate or give error if biggger values inserted
    LAST_NAME CHAR(25),                                -- Last name of the worker
    SALARY INT(15),                                    -- Salary of the worker
    JOINING_DATE datetime,                             -- Date and time when the worker joined
    DEPARTMENT CHAR(25)                                -- Department to which the worker belongs
);

-- Inserting records into the Worker table
INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
('001', 'John',    'Doe',    50000, '2020-01-15 09:00:00', 'HR'),
('002', 'Jane',    'Smith',  60000, '2019-03-23 10:30:00', 'Finance'),
('003', 'Michael', 'Brown',  75000, '2018-07-01 11:00:00', 'IT'),
('004', 'Emily',   'Davis',  58000, '2021-05-18 08:45:00', 'HR'),
('005', 'David',   'Wilson', 67000, '2017-11-12 09:20:00', 'Admin'),
('006', 'Sophia',  'Clark',  72000, '2020-09-09 12:00:00', 'IT'),
('007', 'Daniel',  'Lewis',  55000, '2019-12-30 14:10:00', 'Finance'),
('008', 'Olivia',  'Hall',   53000, '2022-01-10 13:30:00', 'Admin');

-- View all records in the Worker table
SELECT * FROM Worker;

-- Creating the Bonus table to store bonus information of workers
CREATE TABLE Bonus(
    WORKER_REF_ID INT,                                  -- Foreign key referring to Worker(WORKER_ID)
    BONUS_AMT INT(10),                                  -- Bonus amount
    BONUS_DATE DATETIME,                                -- Date when the bonus was given
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE                               -- If worker is deleted, bonus records are also deleted
);

-- Inserting bonus data for specific workers
INSERT INTO Bonus (WORKER_REF_ID, BONUS_AMT, BONUS_DATE) VALUES
(1, 5000, '2023-12-25 00:00:00'),
(1, 3000, '2023-12-25 00:00:00'),
(2, 4500, '2023-12-25 00:00:00'),
(2, 2500, '2023-12-25 00:00:00'),
(3, 4000, '2024-03-15 00:00:00');

-- View all records in the Bonus table
SELECT * FROM Bonus;

-- Inserting job title data (before creating table by mistake – but assume table exists)
INSERT INTO Title (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
(1, 'Manager', '2016-02-20 00:00:00'),
(2, 'Executive', '2016-06-11 00:00:00'),
(8, 'Executive', '2016-06-11 00:00:00'),
(5, 'Manager', '2016-06-11 00:00:00'),
(4, 'Asst. Manager', '2016-06-11 00:00:00'),
(7, 'Executive', '2016-06-11 00:00:00'),
(6, 'Lead', '2016-06-11 00:00:00'),
(3, 'Lead', '2016-06-11 00:00:00');

-- Creating Title table to store designations for workers
CREATE TABLE Title(
    WORKER_REF_ID INT,                                   -- Foreign key referencing Worker
    WORKER_TITLE CHAR(25),                               -- Job title of the worker
    AFFECTED_FROM DATETIME,                              -- Date from which the title is effective
    FOREIGN KEY (WORKER_REF_ID)
        REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE                                -- Deletes title entry if worker is deleted
);

-- View all records in the Title table
SELECT * FROM Title;

-- Select first name and salary of all workers
SELECT FIRST_NAME, SALARY FROM Worker;

-- Select worker ID, first name, and salary
SELECT WORKER_ID, FIRST_NAME, SALARY FROM Worker;

-- Get current date and time from the system
SELECT now();

-- Convert string to uppercase
SELECT ucase('Ali MAlik');
SELECT ucase('Ali MAlik');

-- Select workers from HR department
SELECT * FROM Worker WHERE DEPARTMENT = 'HR';

-- Select workers with salary greater than 100000 (no rows likely)
SELECT * FROM Worker WHERE SALARY > 100000;

-- Select workers with salary greater than 10000 (most rows expected)
SELECT * FROM Worker WHERE SALARY > 10000;

-- Select workers with salary more than 50000
SELECT * FROM Worker WHERE SALARY > 50000;

-- Select workers with salary more than 70000
SELECT * FROM Worker WHERE SALARY > 70000;

-- Select workers whose salary is between 50000 and 70000 (inclusive)
SELECT * FROM Worker WHERE SALARY BETWEEN 50000 AND 70000;

-- Same query using >= and <= instead of BETWEEN
SELECT * FROM Worker WHERE SALARY >= 50000 AND SALARY <= 70000;

-- Select workers from HR or Admin departments using OR
SELECT * FROM Worker WHERE DEPARTMENT = 'HR' OR DEPARTMENT ='Admin';

-- Select workers from HR or Admin departments using IN
SELECT * FROM Worker WHERE DEPARTMENT IN ('HR','Admin');

-- Select workers from departments other than HR and Admin using NOT IN
SELECT * FROM Worker WHERE DEPARTMENT NOT IN ('HR','Admin');

-- Incorrect logic: this condition always true. Should use AND instead of OR
SELECT * FROM Worker WHERE DEPARTMENT != 'HR' OR DEPARTMENT !='Admin';

-- Correct logic to exclude both HR and Admin
SELECT * FROM Worker WHERE DEPARTMENT != 'HR' AND DEPARTMENT !='Admin';

-- Select workers whose first name contains letter 'i'
SELECT * FROM Worker WHERE FIRST_NAME LIKE '%i%';

-- Order workers by salary in ascending order (default)
SELECT * FROM Worker ORDER BY SALARY;

-- Order workers by salary in descending order
SELECT * FROM Worker ORDER BY SALARY DESC;

-- Show all departments (repetition allowed)
SELECT DEPARTMENT FROM Worker;

-- Show only distinct (unique) departments
SELECT DISTINCT DEPARTMENT FROM Worker;

-- Aggregation / GROUP BY
SELECT DEPARTMENT FROM WORKER GROUP BY DEPARTMENT; -- THis works similar like DISTINCT since we didnt provide any aggregation

-- Using COUNT 
SELECT DEPARTMENT, COUNT(DEPARTMENT) FROM WORKER GROUP BY DEPARTMENT; -- The arugument inside count is basically used to name the count table in view, For our understanding you can name anything

-- Find average salary per department
SELECT DEPARTMENT, AVG(SALARY) FROM Worker GROUP BY DEPARTMENT;

-- Find MIN salary across dept
SELECT department, MIN(salary) FROM Worker GROUP BY department;

-- Find MAX salary across dept
SELECT department, MAX(salary) FROM Worker GROUP BY department;

-- Find SUM salary across dept
SELECT department, SUM(salary) FROM Worker GROUP BY department;

-- GROUP BY HAVING
SELECT department, COUNT(department) FROM Worker GROUP BY department HAVING COUNT(department) >= 2;

USE temp;

-- Check  contraint

CREATE TABLE Account(
	id INT PRIMARY KEY, 
    name VARCHAR(225) UNIQUE, -- Ensures each name is unique in the table
    balance INT,
    CONSTRAINT acc_balance_chk CHECK(balance > 1000) -- Ensures balance is always more than 1000
);

-- 🔹 UNIQUE Constraint
-- Purpose:
-- Ensures that no two rows have the same value in the 'name' column.

-- How it works:
-- If you try to insert:
-- INSERT INTO Account (name, balance) VALUES ('Alice', 2000);
-- INSERT INTO Account (name, balance) VALUES ('Alice', 3000); -- ❌ Error
-- The second insert fails because 'Alice' is already present.

-- UNIQUE can be applied to:
-- • A single column: as in name VARCHAR(225) UNIQUE
-- • Multiple columns: using UNIQUE(name, balance) to ensure combinations are unique.

-- Behind the scenes, it creates a unique index to enforce fast checking.

-- 🔹 CHECK Constraint
-- Purpose:
-- Enforces a condition on values entered in a column. In this case:

-- CONSTRAINT acc_balance_chk CHECK(balance > 1000)

-- Meaning:
-- Only allows rows where the balance value is strictly greater than 1000.

-- What it does:
-- The following will succeed:
-- INSERT INTO Account (name, balance) VALUES ('Bob', 1500);

-- But this will fail:
-- INSERT INTO Account (name, balance) VALUES ('Tom', 800); -- ❌ Error: balance not > 1000

-- The constraint is named 'acc_balance_chk' — naming is optional, but useful for debugging or altering later.

-- CHECK constraints can also apply to complex expressions, such as:
-- CHECK(balance > 1000 AND balance < 100000)


-- DEFAULT
DROP TABLE Account;
CREATE TABLE Account(
	id INT PRIMARY KEY, 
    name VARCHAR(225) UNIQUE, -- Ensures each name is unique in the table
    balance INT NOT NULL DEFAULT 0
);

INSERT INTO Account(id,name) Values (1,'Ali');
SELECT * FROM Account;
-- 🔹 ONLY NOT NULL
-- • Ensures column must always have a value.
-- • You MUST provide a value during insert.
-- • If value is missing or NULL, insert fails.
-- • No automatic/default value is applied.

-- Example:
-- CREATE TABLE Users (name VARCHAR(100) NOT NULL);
-- INSERT INTO Users (name) VALUES ('Ali');   -- ✅ Works
-- INSERT INTO Users () VALUES ();            -- ❌ Error: NULL not allowed
-- INSERT INTO Users (name) VALUES (NULL);    -- ❌ Error: NULL not allowed

-- 🔹 ONLY DEFAULT
-- • Applies a default value if no value is provided.
-- • NULL can still be inserted explicitly.
-- • Column may end up with NULL if user provides it.

-- Example:
-- CREATE TABLE Users (name VARCHAR(100) DEFAULT 'Guest');
-- INSERT INTO Users () VALUES ();            -- ✅ name = 'Guest'
-- INSERT INTO Users (name) VALUES ('Ali');   -- ✅ name = 'Ali'
-- INSERT INTO Users (name) VALUES (NULL);    -- ✅ name = NULL

-- 🔹 NOT NULL + DEFAULT
-- • Guarantees column always has a non-null value.
-- • If value is missing, default is applied.
-- • NULL insertion is rejected.

-- Example:
-- CREATE TABLE Users (name VARCHAR(100) NOT NULL DEFAULT 'Guest');
-- INSERT INTO Users () VALUES ();            -- ✅ name = 'Guest'
-- INSERT INTO Users (name) VALUES ('Ali');   -- ✅ name = 'Ali'
-- INSERT INTO Users (name) VALUES (NULL);    -- ❌ Error: NOT NULL violation

-- 🔹 Summary
-- NOT NULL only       → Requires value, no fallback.
-- DEFAULT only        → Optional value, NULLs allowed.
-- NOT NULL + DEFAULT  → Always filled, NULLs rejected.



-- Add a column to Account named Interest Rate
ALTER TABLE Account ADD Interest FLOAT NOT NULL DEFAULT 0;

-- 🔹 ALTER TABLE with ONLY NOT NULL
-- • In strict SQL (PostgreSQL, etc.), this fails if data exists (NULLs not allowed).
-- • But in MySQL, the column is added successfully.
-- • MySQL auto-fills existing rows with a **default zero value** (e.g., 0 for INT).

-- Example (MySQL behavior):
-- ALTER TABLE Account ADD Interest_rate INT NOT NULL;
-- → Existing rows get Interest_rate = 0
-- → No error, but could be misleading if 0 is not a meaningful default.

-- 🔹 ALTER TABLE with ONLY DEFAULT
-- • Adds the column with a default value.
-- • Existing rows get NULL (default not retroactively applied).
-- • New inserts use the default if no value is provided.

-- Example:
-- ALTER TABLE Account ADD Interest_rate INT DEFAULT 5;
-- → Existing rows: NULL
-- → New rows: 5 if no value given

-- 🔹 ALTER TABLE with NOT NULL + DEFAULT
-- • Safest and cleanest approach.
-- • Column added, all existing rows get the default.
-- • NULLs are disallowed; default used if no value is given.

-- Example:
-- ALTER TABLE Account ADD Interest_rate INT NOT NULL DEFAULT 5;
-- → Existing rows: 5
-- → New rows: 5 (if not specified), no NULLs allowed

-- 🔹 Summary (MySQL specific note):
-- NOT NULL alone: ✅ works in MySQL, auto-fills 0
-- DEFAULT alone: ✅ applies only to new rows, existing get NULL
-- NOT NULL + DEFAULT: ✅ fills all rows, safest for non-null logic

-- MODIFY 
ALTER TABLE Account MODIFY Interest DOUBLE NOT NULL default 0;
-- 🔹 CASE 1: ONLY NOT NULL
-- ALTER TABLE Account MODIFY Interest DOUBLE NOT NULL;
--
-- ▪ MySQL checks for existing NULLs in the 'Interest' column.
-- ▪ ❌ If any row has NULL → the statement fails.
-- ▪ ✅ If all values are already non-null → constraint is added successfully.
-- ▪ ⚠️ Existing NULLs are NOT automatically changed or filled.
-- ▪ 🚫 No default is applied → new inserts MUST provide a value explicitly.

-- 🔹 CASE 2: ONLY DEFAULT
-- ALTER TABLE Account MODIFY Interest DOUBLE DEFAULT 0;
--
-- ▪ Adds a default value of 0 for future inserts.
-- ▪ ✅ Old rows are left untouched — existing NULLs remain NULL.
-- ▪ ✅ New rows will use default (0) if no value is provided during INSERT.
-- ▪ ❌ Does NOT prevent future NULLs from being inserted — NULLs still allowed.

-- 🔹 CASE 3: NOT NULL + DEFAULT
-- ALTER TABLE Account MODIFY Interest DOUBLE NOT NULL DEFAULT 0;
--
-- ▪ MySQL checks for NULLs in the column.
-- ▪ ❌ If any row contains NULL → the statement fails.
-- ▪ ✅ If all values are non-null → NOT NULL is enforced, default is set.
-- ▪ ⚠️ Existing NULLs are NOT auto-replaced with the default value.
-- ▪ ✅ New inserts will receive default (0) if no value is provided.

-- 🔸 Summary Table:
-- | Constraint Type       | Fails on NULLs | Changes Old Rows | Applies to New Inserts |
-- |-----------------------|----------------|------------------|------------------------|
-- | NOT NULL only         | ✅ Yes         | ❌ No             | 🚫 Must specify value  |
-- | DEFAULT only          | ❌ No          | ❌ No             | ✅ Yes                 |
-- | NOT NULL + DEFAULT    | ✅ Yes         | ❌ No             | ✅ Yes                 |

-- 🔹 Recommended Safe Approach for MODIFY:
-- Step 1: Update old NULLs
--   UPDATE Account SET Interest = 0 WHERE Interest IS NULL;
-- Step 2: Modify with constraints
--   ALTER TABLE Account MODIFY Interest DOUBLE NOT NULL DEFAULT 0;

-- CHANGE Rename the column name
ALTER TABLE Account CHANGE COLUMN Interest saving_interest FLOAT NOT NULL DEFAULT 0;

-- Describing the table;
DESC Account;

-- Drop column
ALTER TABLE Account DROP COLUMN Interest;

-- Rename the table
ALTER TABLE Account RENAME TO Account_details;

SELECT * FROM Account;

CREATE TABLE Customer(
	id INT PRIMARY KEY UNIQUE NOT NULL,
    c_name VARCHAR(225),
    Address VARCHAR(225),
    Gender CHAR(2),
    City VARCHAR(225),
    Pincode INTEGER
);
-- Ways to do insertion
INSERT INTO Customer 
VAlUES  (1251,'Ram Kumar','Dilbagh Nagar','M','Jalandhar',144002),
		(1300,'Shayan Singh','Ludiana H.O','M','Ludhiana',141001),
        (245,'Neelabh Shukla','Ashok Nagar','M','Jalandhar',144003),
        (210,'Barkha Singh','Dilbagh Nagar','F','Jalandhar',144002),
        (500,'Rohan Arora','Ludhiana H.O','M','Ludhiana',141001);
        
INSERT INTO Customer(id,c_name,Address,Gender,City,Pincode)
VALUES (1252,'Ram Kumar3','Dilbagh Nagar','M','Jalandhar',NULL);

INSERT INTO Customer VAlUES (121,'Bob','Jamnapar','F','Delhi',NULL);

-- Update any value
UPDATE Customer SET Address ='Mumbai', Gender='M' WHERE id =121;

-- Update multiple rows
-- SQL safe updates doesnt allow you to update multiple rows  at a time
SET SQL_SAFE_UPDATES = 0;
UPDATE Customer SET PINCODE = 141200;
-- After updting make sure SQL_SAFE_UPDATES to 0

-- DELETE a row
DELETE FROM Customer; -- will delete all the rows
DELETE FROM Customer WHERE id = 121;

SELECT * FROM Customer;

-- Creating the Order_details table with a foreign key referencing the Customer table
-- No ON DELETE behavior is specified, so default is RESTRICT (error on deletion if referenced)
CREATE TABLE Order_details (
	Order_id INT PRIMARY KEY,
    delivery_date DATE,
    cust_id INT,
    FOREIGN KEY (cust_id) REFERENCES Customer(id)
);

-- Inserting a record into the Customer table (the parent table)
-- This entry will be referenced in the Order_details table
INSERT INTO Customer VALUES (121, 'Bob', 'Jamnapar', 'F', 'Delhi', NULL);

-- Inserting a record into Order_details with a foreign key referencing Bob's customer ID
INSERT INTO Order_details 
VALUES (1, '2025-3-25', 121);

-- Attempting to delete the Customer record for ID 121
-- This will throw an error because the child table (Order_details) still references this ID
-- By default, deletion is restricted to maintain referential integrity
DELETE FROM Customer WHERE id = 121;



-- Now demonstrating ON DELETE CASCADE behavior
-- First, drop the existing Order_details table
DROP TABLE Order_details;

-- Recreate the Order_details table with ON DELETE CASCADE
-- This means if a referenced Customer is deleted, the corresponding Order_details will also be deleted automatically
CREATE TABLE Order_details (
	Order_id INT PRIMARY KEY,
    delivery_date DATE,
    cust_id INT,
    FOREIGN KEY (cust_id) REFERENCES Customer(id)
    ON DELETE CASCADE
);

-- Insert the same records again into both tables
INSERT INTO Order_details 
VALUES (1, '2025-3-25', 121);

-- Now deleting the Customer record for ID 121 will also delete the matching Order_details record
-- This avoids referential integrity issues without manual deletion of child entries
DELETE FROM Customer WHERE id = 121;



-- Now demonstrating ON DELETE SET NULL behavior
-- Drop the table again before redefining it
DROP TABLE Order_details;

-- Recreate Order_details with ON DELETE SET NULL
-- When the referenced Customer is deleted, the cust_id in Order_details will be set to NULL
CREATE TABLE Order_details (
	Order_id INT PRIMARY KEY,
    delivery_date DATE,
    cust_id INT,
    FOREIGN KEY (cust_id) REFERENCES Customer(id)
    ON DELETE SET NULL
);

-- Insert a customer and related order again
INSERT INTO Customer VALUES (121, 'Bob', 'Jamnapar', 'F', 'Delhi', NULL);
INSERT INTO Order_details 
VALUES (1, '2025-3-25', 121);

-- Now deleting the Customer will NOT delete the Order_details record
-- Instead, the cust_id field in the child table will be set to NULL
DELETE FROM Customer WHERE id = 121;

-- Query to view the effect: cust_id should now be NULL in the order record
SELECT * FROM Order_details;


-- REPLACE INTO is used to insert a new row or replace an existing row based on a PRIMARY KEY or UNIQUE KEY.
-- If a row with the same primary key exists, it deletes that row and inserts the new one (not an UPDATE, but a DELETE + INSERT).
-- If the primary key does not exist, it behaves like a normal INSERT.

-- First, insert a customer record (with id = 121)
INSERT INTO Customer VALUES (121, 'Bob', 'Jamnapar', 'F', 'Delhi', NULL);

-- Attempting to REPLACE a record with an existing primary key (id = 121)
-- Since 'id' is the primary key, this REPLACE will first delete the existing record with id = 121
-- Then it will insert a new record with id = 121 and City = 'Mumbai'
-- All other unspecified columns will be inserted as NULL (so be careful!)
REPLACE INTO Customer(id, City)
VALUES (121, 'Mumbai');

-- Check the updated Customer table
SELECT * FROM Customer;

-- Now performing REPLACE where the id does NOT already exist in the table (id = 123)
-- Since there's no existing entry with id = 123, this acts as a normal INSERT
REPLACE INTO Customer(id, City)
VALUES (123, 'Mumbai');

-- Another way to use REPLACE INTO using SET syntax
-- This will insert a new customer with id = 1200 or replace if it already exists
REPLACE INTO Customer SET id = 1200, c_name = 'Mac', City = 'Utah';

-- Inserting a new complete entry with id = 1214
INSERT INTO Customer VALUES (1214, 'Boby', 'Kota', 'F', 'Jaipur', NULL);

-- Using REPLACE with a SELECT statement
-- This selects id, c_name, and City from an existing row (id = 1214) and replaces the entry
-- Since only 3 columns are mentioned, the other columns will be set to NULL in the new inserted row
REPLACE INTO Customer(id, c_name, City)
	SELECT id, c_name, City
    FROM Customer WHERE id = 1214;

-- Final check: display the entire Customer table
SELECT * FROM Customer;

USE temp;
-- INSERT into Order_details
INSERT INTO Order_details (Order_id, delivery_date, cust_id) VALUES
	(201, '2025-06-01', 1251),   -- Ram Kumar
	(202, '2025-06-03', 1300),   -- Shayan Singh
	(203, '2025-06-05', 245),    -- Neelabh Shukla
	(204, '2025-06-07', 210),    -- Barkha Singh
	(205, '2025-06-09', 500),    -- Rohan Arora
	(206, '2025-06-10', 245),    -- Neelabh again (to test multi-order)
	(207, '2025-06-12', NULL);   -- NULL customer (intentional)
    
-- ========================================
-- INNER JOIN: Returns only matching rows
-- ========================================
-- Retrieves only the rows where there is a match between Customer and Order_details.
-- If a customer has no order, or an order has no valid customer (cust_id is NULL or invalid), it will be excluded.
SELECT C.*, O.*
FROM Customer AS C
INNER JOIN Order_details AS O
ON C.id = O.cust_id;

-- ========================================
-- LEFT JOIN: All from Customer + matched Orders
-- ========================================
-- Returns all customers, even if they haven’t placed any orders.
-- Orders will appear NULL if no corresponding order exists for a customer.
SELECT C.*, O.*
FROM Customer AS C
LEFT JOIN Order_details AS O
ON C.id = O.cust_id;

-- ========================================
-- RIGHT JOIN: All from Order_details + matched Customers
-- ========================================
-- Returns all orders, including those that do not have a matching customer (e.g., deleted customers or NULL foreign keys).
-- Customer fields will appear NULL for unmatched orders.
SELECT C.*, O.*
FROM Customer AS C
RIGHT JOIN Order_details AS O
ON C.id = O.cust_id;

-- ========================================
-- FULL OUTER JOIN: All Customers + All Orders
-- ========================================
-- Combines LEFT and RIGHT JOIN results.
-- Returns all customers and all orders, matching where possible.
-- If there’s no match, the respective side will show NULL.
-- MySQL doesn't support FULL JOIN directly, so we use UNION of LEFT and RIGHT JOIN.
SELECT C.*, O.*
FROM Customer AS C
LEFT JOIN Order_details AS O
ON C.id = O.cust_id
UNION
SELECT C.*, O.*
FROM Customer AS C
RIGHT JOIN Order_details AS O
ON C.id = O.cust_id;

-- ========================================
-- CROSS JOIN: Cartesian Product
-- ========================================
-- Returns **every possible combination** of rows from both tables.
-- If Customer has 5 rows and Order_details has 8 rows,
-- the result will contain 5 × 8 = 40 rows.
-- Useful in scenarios like generating combinations, reports, etc.
-- Not typically used for FK-PK relationships as it ignores join conditions.
SELECT C.*, O.*
FROM Customer AS C
CROSS JOIN Order_details AS O;

-- SELF JOIN
-- ==========================================
-- Step 1: Create the Employee Table
-- ==========================================
-- This table stores employee information including their salary and manager
CREATE TABLE Employee (
    id INT PRIMARY KEY,           -- Unique identifier for each employee
    name VARCHAR(100),            -- Employee's name
    salary INT,                   -- Employee's salary
    managerId INT                 -- ID of the employee's manager (foreign key-like reference to id)
);

-- ==========================================
-- Step 2: Insert Sample Data into Employee
-- ==========================================
-- Adding a mix of employees with and without managers
INSERT INTO Employee (id, name, salary, managerId) VALUES
(1, 'Joe', 70000, 3),    -- Joe's manager is Sam (id = 3)
(2, 'Henry', 80000, 4),  -- Henry's manager is Max (id = 4)
(3, 'Sam', 60000, NULL), -- Sam has no manager
(4, 'Max', 90000, NULL); -- Max has no manager

-- ==========================================
-- Step 3: Self JOIN to find employees who earn more than their manager
-- ==========================================
-- We join the Employee table with itself:
-- - E: current employee
-- - M: manager (also an employee)
-- We compare each employee's salary with their manager's salary
SELECT E.name AS Employee
FROM Employee AS E
JOIN Employee AS M
    ON E.managerId = M.id
WHERE E.salary > M.salary;

-- Exercise for JOINS
-- ========================================
-- Table: EMPLOYEE
-- ========================================
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    fname VARCHAR(50),
    lname VARCHAR(50),
    Age INT,
    emailID VARCHAR(100),
    PhoneNo VARCHAR(20),
    City VARCHAR(50)
);

INSERT INTO Employee (id, fname, lname, Age, emailID, PhoneNo, City) VALUES
(1, 'Aman', 'Proto', 32, 'aman@gmail.com', '898', 'Delhi'),
(2, 'Yagya', 'Narayan', 44, 'yagya@gmail.com', '222', 'Palam'),
(3, 'Rahul', 'BD', 22, 'rahul@gmail.com', '444', 'Kolkata'),
(4, 'Jatin', 'Hermit', 31, 'jatin@gmail.com', '666', 'Raipur'),
(5, 'PK', 'Pandey', 21, 'pk@gmail.com', '555', 'Jaipur');

-- ========================================
-- Table: CLIENT (empID references Employee)
-- ========================================
CREATE TABLE Client (
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    Age INT,
    emailID VARCHAR(100),
    PhoneNo VARCHAR(20),
    City VARCHAR(50),
    empID INT,
    FOREIGN KEY (empID) REFERENCES Employee(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

INSERT INTO Client (id, first_name, last_name, Age, emailID, PhoneNo, City, empID) VALUES
(1, 'Mac', 'Rogers', 47, 'mac@hotmail.com', '333', 'Kolkata', 3),
(2, 'Max', 'Polifer', 27, 'max@gmail.com', '222', 'Kolkata', 3),
(3, 'Peter', 'Jain', NULL, 'peter@abc.com', '111', 'Delhi', 1),
(4, 'Sushant', 'Aggarwal', NULL, 'sushant@yahoo.com', '45454', 'Hyderabad', 4),
(5, 'Pratap', 'Singh', NULL, 'p@xyz.com', '77767', 'Mumbai', 2);



-- ========================================
-- Table: PROJECT (empID → Employee, clientID → Client)
-- ========================================
CREATE TABLE Project (
    id INT PRIMARY KEY,
    empID INT,
    name VARCHAR(50),
    startdate DATE,
    clientID INT,
    FOREIGN KEY (empID) REFERENCES Employee(id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (clientID) REFERENCES Client(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

INSERT INTO Project (id, empID, name, startdate, clientID) VALUES
(1, 1, 'A', '2021-04-21', 3),
(2, 2, 'B', '2021-03-12', 1),
(3, 3, 'C', '2021-01-16', 5),
(4, 3, 'D', '2021-04-27', 2),
(5, 5, 'E', '2021-05-01', 4);

-- INNER JOIN
-- Enlist all the employees ID's , name, along with the project allocated to them
SELECT e.id,e.fname,e.lname, p.id, p.name 
FROM Employee as E 
INNER JOIN 
	Project as P
ON e.id = p.empID;

-- Fetch out all the employee ID's and their contact detail who have been working from Jaipur
-- with the clients name working in Hyderabad

SELECT e.id, e.emailID, e.PhoneNo, c.first_name, c.last_name 
FROM Employee AS e 
INNER JOIN Client AS c 
ON e.id = c.empId
WHERE e.City = 'Raipur' AND c.City = 'Hyderabad';

-- Fetch out each Project allocated to each employee
Select * FROM Employee as e LEFT JOIN Project AS p ON e.id = p.empId ;

-- List out all the possible combination possible for the employee's name and project taht can exist
SELECT e.fname,e.lname, p.id, p.name 
FROM Employee AS e
CROSS JOIN Project AS p;

-- Can we do join without using the JOIN keyword
SELECT e.id,e.fname,e.lname, p.id, p.name 
FROM Employee as E ,Project as P
WHERE e.id = p.empID;

-- SET operators
-- ================================================
-- SQL SET OPERATORS EXPLANATION WITH DEMO DATA
-- ================================================

-- ================================================
-- STEP 1: Create Sample Tables
-- ================================================

-- Table A: Contains some employee records
CREATE TABLE TableA (
    id INT,
    name VARCHAR(50)
);

-- Insert data into TableA
INSERT INTO TableA (id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie'),
(4, 'David');

-- Table B: Contains another set of employee records
CREATE TABLE TableB (
    id INT,
    name VARCHAR(50)
);

-- Insert data into TableB
INSERT INTO TableB (id, name) VALUES
(3, 'Charlie'),
(4, 'David'),
(5, 'Eve'),
(6, 'Frank');

-- ================================================
-- SET OPERATOR 1: UNION
-- ================================================
-- Combines results from both TableA and TableB
-- Removes duplicate rows automatically
SELECT * FROM TableA
UNION
SELECT * FROM TableB;

-- ================================================
-- SET OPERATOR 2: UNION ALL
-- ================================================
-- Combines results from both tables
-- Keeps duplicate rows
SELECT * FROM TableA
UNION ALL
SELECT * FROM TableB;

-- ================================================
-- SET OPERATOR 3: INTERSECT (Not supported in MySQL)
-- ================================================
-- Returns only rows that exist in both tables
-- Automatically removes duplicates
-- Use this if your SQL engine supports INTERSECT
-- SELECT * FROM TableA
-- INTERSECT
-- SELECT * FROM TableB;

-- MySQL-compatible alternative using WHERE IN
SELECT * FROM TableA
WHERE (id, name) IN (SELECT id, name FROM TableB);

SELECT DISTINCT A.id, A.name
FROM TableA AS A
INNER JOIN TableB AS B
    ON A.id = B.id AND A.name = B.name;

-- ===========================================
-- DEMO: INNER JOIN using USING vs ON
-- ===========================================

-- Create TableA
CREATE TABLE TableA (
    id INT,
    name VARCHAR(50)
);

-- Create TableB
CREATE TABLE TableB (
    id INT,
    name VARCHAR(50)
);

-- Insert sample data into TableA
INSERT INTO TableA (id, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie'),
(3, 'Charlie'),
(4, 'David');

-- Insert sample data into TableB
INSERT INTO TableB (id, name) VALUES
(3, 'Charlie'),
(3, 'Charlie'),
(4, 'David'),
(5, 'Eve'),
(6, 'Frank');

-- ====================================================
-- USING clause in INNER JOIN
-- ====================================================
-- ✅ WHEN TO USE USING:
-- - Only for equality joins
-- - Only if column names are identical in both tables
-- - Simplifies: ON table1.col = table2.col  -->  USING (col)

-- ✅ Example: USING (id, name)
-- Joins TableA and TableB on both id and name
-- DISTINCT ensures the result mimics INTERSECT (removes duplicates)
SELECT DISTINCT id, name
FROM TableA
INNER JOIN TableB
USING (id, name);

-- ====================================================
-- Equivalent INNER JOIN using ON clause
-- ====================================================
-- 🔁 Same result, more verbose
-- Can be used even if column names are different
SELECT DISTINCT A.id, A.name
FROM TableA AS A
INNER JOIN TableB AS B
ON A.id = B.id AND A.name = B.name;

-- ⚠️ Reminder:
-- If the column names differ (e.g. TableA.id vs TableB.emp_id),
-- the USING clause cannot be used — use ON instead.



-- ================================================
-- SET OPERATOR 4: EXCEPT (Not supported in MySQL)
-- ================================================
-- Returns rows from TableA that are NOT in TableB
-- Automatically removes duplicates
-- Use this if your SQL engine supports EXCEPT
-- SELECT * FROM TableA
-- EXCEPT
-- SELECT * FROM TableB;

-- MySQL-compatible alternative using WHERE NOT IN
SELECT * FROM TableA
WHERE (id, name) NOT IN (SELECT id, name FROM TableB);

-- Get back to Employee, Client and Project table
-- Exercise\
-- SUBQUERIES

-- employee with age > 30
SELECT * FROM Employee WHERE Age > 30;
SELECT * FROM Employee WHERE Age IN (SELECT Age FROM Employee WHERE Age > 30);

-- employee details working in more than one project
SELECT * FROM Employee WHERE id IN (SELECT empId FROM Project GROUP BY empId HAVING COUNT(empID) > 1);

-- single value SUBQUERY
-- emp details having age > avg(age)
SELECT *
FROM Employee
WHERE Age > (SELECT AVG(Age) FROM Employee);

-- select max age whose first name has a
SELECT max(Age) FROM Employee WHERE fname LIKE '%a%';
SELECT max(Age) FROM (SELECT * FROM Employee WHERE fname LIKE '%a%') AS temp;

-- find details of that max Age whose first name has a
SELECT *
FROM Employee
WHERE fname LIKE '%a%'
AND Age = (
    SELECT MAX(Age)
    FROM Employee
    WHERE fname LIKE '%a%'
);

-- find details of max AGe of an Employee
SELECT * FROM Employee
WHERE Age IN ( SELECT Max(Age) FROM Employee);

-- Co-related Query
-- find third oldest employee
















-- ✅ SQL Order of Execution (NOT the order we write in)

-- 1. FROM
--    - Loads the base tables.
--    - If multiple tables are used, begins joining them.

-- 2. JOIN / ON
--    - Applies JOIN conditions (e.g., ON A.id = B.id).
--    - Joins rows between tables.

-- 3. WHERE
--    - Filters rows from the result of the FROM + JOIN steps.
--    - Only filters **non-aggregated** data (before GROUP BY).

-- 4. GROUP BY
--    - Groups the filtered rows based on specified columns.
--    - Enables use of aggregate functions like COUNT(), SUM(), AVG().

-- 5. HAVING
--    - Filters the **groups** created in GROUP BY.
--    - Use it to filter based on aggregated values (e.g., COUNT(*) > 5).

-- 6. SELECT
--    - Chooses what columns/expressions to return.
--    - Can include aggregated columns and calculated expressions.

-- 7. DISTINCT
--    - Removes duplicate rows from the final result of SELECT.

-- 8. ORDER BY
--    - Sorts the final result set (after SELECT and DISTINCT).
--    - Can sort by columns, aliases, or expressions.

-- 9. LIMIT / OFFSET
--    - Limits the number of rows returned.
--    - OFFSET skips rows before returning the LIMIT number.

-- 📌 Example query with correct flow:

-- SELECT department, COUNT(*) AS emp_count
-- FROM employees
-- WHERE salary > 50000
-- GROUP BY department
-- HAVING COUNT(*) > 5
-- ORDER BY emp_count DESC
-- LIMIT 3;

-- SQL Engine internally processes this in the above order (steps 1–9).









