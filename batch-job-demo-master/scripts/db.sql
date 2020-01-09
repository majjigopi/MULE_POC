/* Used DATABASE name is usermodel. */

/* CREATE DATABASE usermodel; */
/* USE usermodel; */

/* DROP the existing tables. Comment this out if it is not needed. */

CREATE DATABASE usermodel;
USE usermodel;

DROP TABLE Users;
DROP TABLE Accounts;
DROP TABLE Status;



/* Create the full set of User Model Tables */

CREATE TABLE Status (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(50) NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_date DATE NOT NULL,
  updated_by VARCHAR(50),
  updated_date DATE
);


CREATE TABLE Users (
  id INTEGER NOT NULL PRIMARY KEY,
  user_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  status INTEGER NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_date DATE NOT NULL,
  updated_by VARCHAR(50),
  updated_date DATE,
  FOREIGN KEY (status) REFERENCES Status(id)
);


CREATE TABLE Accounts (
  id INTEGER NOT NULL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  created_by VARCHAR(50) NOT NULL,
  created_date DATE NOT NULL,
  updated_by VARCHAR(50),
  updated_date DATE,
  credit_limit DOUBLE NULL,
  active CHAR(1),
  FOREIGN KEY (user_id) REFERENCES Users(id)
);


INSERT INTO Status (id, name, description, created_by, created_date) values (10, 'APPROVED', 'Approved User', 'Fattouh', '2014/12/11');
INSERT INTO Status (id, name, description, created_by, created_date) values (20, 'REJECTED', 'Rejected User', 'Fattouh', '2014/12/11');
INSERT INTO Status (id, name, description, created_by, created_date) values (30, 'PENDING_APPROVED', 'Pending Approval User', 'Fattouh', '2014/12/11');


INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(100, 'test1', 'test1', 'test1', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(101, 'test2', 'test2', 'test2', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(102, 'test3', 'test3', 'test3', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(103, 'test4', 'test4', 'test4', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(104, 'test5', 'test5', 'test5', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(105, 'af', 'af', 'af', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(106, 'bf', 'bf', 'bf', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(107, 'aaaa', 'aaaa', 'aaa', 10, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(108, 'bbbb', 'bbbb', 'bbb', 20, 'admin', '2014/12/11');
INSERT INTO users(id, user_name, last_name, first_name, status, created_by, created_date) values(109, 'cccc', 'ccc', 'ccc', 10, 'admin', '2014/12/11');



INSERT INTO accounts(id, user_id, created_by, created_date, credit_limit, active) values(1000, 100, 'Fattouh', '2014/12/11', 2000, 'Y');
INSERT INTO accounts(id, user_id, created_by, created_date, credit_limit, active) values(1001, 101, 'Fattouh', '2014/12/11', 1000, 'Y');
INSERT INTO accounts(id, user_id, created_by, created_date, credit_limit, active) values(1002, 102, 'Fattouh', '2014/12/11', 2000, 'Y');
INSERT INTO accounts(id, user_id, created_by, created_date, credit_limit, active) values(1003, 103, 'Fattouh', '2014/12/11', 4000, 'Y');
INSERT INTO accounts(id, user_id, created_by, created_date, credit_limit, active) values(1004, 104, 'Fattouh', '2014/12/11', 4000, 'Y');






