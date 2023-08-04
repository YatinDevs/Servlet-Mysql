create database constraintsExample;
use constraintsExample;
-- null constriant
create table nullExample
(
Emp_name varchar(30),
age int
);

select * from nullExample;
insert into nullExample(Emp_name,Age) values ('Rajesh',23);

insert into nullExample(Age) values (26);

drop table notnullExample;
-- not null constriant
create table notnullExample
(
Emp_name varchar(30) not null,
age int
);

select * from notnullExample;

insert into notnullExample(Emp_name,Age) values ('Rajesh',23);

insert into notnullExample(Age) values (26);

-- default constraint
create table DefaultExample
(
Emp_name varchar(30) not null,
age int,
Mobile varchar(50) default 'Mobile No Not Available'
);

select * from DefaultExample;

insert into DefaultExample(Emp_name,Age,Mobile) values ('Rajesh',23,9549451678);
insert into DefaultExample(Emp_name,Age) values ('Pankaj',23);

-- check constraint
create table checkExample
(
Emp_name varchar(30) not null,
Age int,check(age>=18)

);
insert into checkExample(Emp_name,Age) values ('Rajesh',23);
insert into checkExample(Emp_name,Age) values ('sanket',17);
insert into checkExample(Emp_name,Age) values ('priya',28);

select * from checkExample;

-- unique constraint
-- the data is different and unique it is looked out

create table UniqueExample
(
Emp_name varchar(50) not null,
age int,
Mobile varchar(50) not null unique
);
insert into UniqueExample(Emp_name,Age,Mobile) values ('Rajesh',23,9549451678);
insert into UniqueExample(Emp_name,Age,Mobile) values ('Jason',25,9549451678);

select * from UniqueExample;

-- primary key Constraint 
-- unique values, cannot contain null value

create table department
(
Dept_Id int primary Key ,
Dept_name varchar(50)
);

insert into department values(1,'account');
insert into department values(2,'HR');
insert into department values(3,'IT');

select * from department;


create table employeeDetails
(
Emp_id int primary key,
Emp_name varchar(40) not null,
Dept_Id int,
Foreign key (Dept_Id) references Department(Dept_Id)
);

insert into employeeDetails values(1,'Raj',1);
insert into employeeDetails values(2,'Rahul',2);
insert into employeeDetails values(3,'Kunal',3);

select * from employeeDetails;
insert into employeeDetails values(4,'Sunal',1);