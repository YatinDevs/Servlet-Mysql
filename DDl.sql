create database cdac;
create database pgdaca;

create database cdacnoida;
-- switch to the cdac database
use cdac;
-- show the list of database
show tables;
show databases;
use sakila;
show tables;

-- create table student
create table student
(
roll_no int,
s_name varchar(40),
age int,
phone bigint,
branch varchar(20),
city varchar(20),
gender char
);

-- display the structure of the  table
desc student;
/* change the structure of the table through Alter command
1. add a column/list of columns
2. modify the datatype/size of a column
3. Drop a column if it is not required
4. Rename a column */

alter table student modify s_name varchar(30);

desc student;

use cdac;
show tables;
-- To diplay the name of current database
select database();

desc student;

show create table student;

/* create table with constraints
1. unique key integrity constraint -> Primary key
2. Referential integrity constraint -> Foreign key
3. Unique key constraint
4. not null constraint
5. check constraint
*/
-- column level constraint definition
create table student1( 
roll_no int primary key,
student_name varchar(20)
);

desc student1;
-- table level constraint definition
create table book_detail(
isbn bigint ,
author varchar(30) ,
title varchar(50),
constraint pk1_book_isbn_author primary key(isbn,author)

);

create table student2(
roll_no int,
sname varchar(30),
age int,
primary key(roll_no)
);

desc book_detail;
show tables;
show tables;


-- define not null constraint 
create table student4(
roll_no int primary key,
s_name varchar(30) not null,
age int,
mobile_no bigint not null
);

-- describe the structure
desc student4;


-- unique constraint
create table student5(
roll_no int ,
s_name varchar(30) not null,
age int,
mobile_no bigint not null,
email_id1 varchar(50) unique,
email_id2 varchar(50) unique,
constraint c1 primary key(roll_no)
);

desc student5;


-- unique constraint and not null together
create table student6(
roll_no int ,
s_name varchar(30) not null,
age int,
mobile_no bigint not null,
email_id1 varchar(50) not null unique,
email_id2 varchar(50) unique,
constraint c1 primary key(roll_no)
);

desc student6;

select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,TABLE_NAME,COLUMN_NAME
from information_schema.key_column_usage
where table_name='student6';


-- check constraint 

create table student7(
roll_no int ,
s_name varchar(30) not null,
age int check (age<=35),
mobile_no bigint not null,
country varchar(10),
state varchar(10),
email_id1 varchar(50) not null,
email_id2 varchar(50),
constraint c1 primary key(roll_no),
constraint c_unique unique(email_id1,email_id2),
check (country='India')
);

desc student7;

select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,TABLE_NAME,COLUMN_NAME
from information_schema.key_column_usage
where table_name='student7';



use cdac;

show tables;


desc information_schema.key_column_usage;



show databases;

desc information_schema.key_column_usage;

create table cdacnoida.t1(a int,b int);

desc cdacnoida.t1;


use cdacnoida;

create table t2(a int,b int);

desc t1;

select * from t1;
select c2,c1
from t1;


select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,TABLE_NAME,COLUMN_NAME
from information_schema.key_column_usage
where table_name='student7';



create table student10(
roll_no int ,
s_name varchar(30) not null,
age int check (age<=35),
mobile_no bigint not null,
country varchar(10),
state varchar(10),
email_id1 varchar(50) not null,
email_id2 varchar(50),
constraint c1 primary key(roll_no),
constraint c_unique1 unique(email_id1),
constraint c_unique2 unique(email_id2),
constraint check_country check (country='India')
);

desc student10;

select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,TABLE_NAME,COLUMN_NAME,CONSTRAINT_TYPE
from information_schema.key_column_usage
where table_name='student10';

show create table student10;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='student10';

desc INFORMATION_SCHEMA.TABLE_CONSTRAINTS;

-- foreign key at column level
create table student11(
rollno int primary key,
sname varchar(20) not null,
cid varchar(10) references course11(cid)
);

drop table student11;

-- because course the reffered tanle is not there , i have to create the table first
create table course11
( cid varchar(10) primary key,
cname varchar(20) not null
);


desc student11;
desc course11;


select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,TABLE_NAME,COLUMN_NAME,CONSTRAINT_TYPE
from information_schema.key_column_usage
where table_name='student10';

show create table student10;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='student11';

-- foreign key at table level
create table student12(
rollno int primary key,
sname varchar(20) not null,
cid varchar(10),
constraint fk_cid_student12 foreign key(cid) references course11(cid)
);

select CONSTRAINT_NAME,CONSTRAINT_SCHEMA,
TABLE_NAME,COLUMN_NAME,
REFERENCED_TABLE_SCHEMA,
REFERENCED_TABLE_NAME,
REFERENCED_COLUMN_NAME
from information_schema.key_column_usage
where table_name='student12';

desc information_schema.key_column_usage;


SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
WHERE TABLE_NAME='student12';


/* Change the structure of the table
1. Add a column/multiple columns
2. Modify the datatype/size ,constraint not null
3. add a constraint
4. remove a column
5. remove constraint
6. rename a column
*/


desc student;
-- add a column
alter table student add email_id varchar(20);
desc student;
-- add multiple columns
alter table student add (country varchar(10),state varchar(10));
desc student;

-- modify the datatype

alter table student modify email_id varchar(50);
-- modify multiple columns
alter table student 
modify column country varchar(20),
modify column state varchar(20);
desc student;

-- drop a column
alter table student drop column city;

desc student;

-- drop multiple column
alter table student 
drop column country,
drop column state;
desc student;
-- rename a column
alter table student change branch course varchar(20);
desc student;
-- create a replica or copy of one table.
create table student_info as select * from student;
desc student_info;
-- Rename a table
-- rename the student_info to student_detail
rename table student_info to student_detail;
desc student_info;
desc student_detail;

-- add constraint
desc student;
-- roll no as primary key
alter table student add primary key(roll_no);

desc student;
-- drop the constraint
alter table student drop primary key;
desc student;



-- drop  a table from the schema
drop table student_detail;
desc student_detail;
-- truncate a table (all data will be lost but structure will be there)
desc t1;
select * from t1;
truncate table t1;
select * from t1;
desc t1;
insert into t1 values(101,'aaa');
select * from t1;

/* DDL create database
create table with constraints
alter
drop
trucate
rename