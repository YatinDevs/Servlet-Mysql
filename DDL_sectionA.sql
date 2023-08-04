use cdac;

create table stud(rollno int primary key,sname varchar(20), age int check(age<=40));
desc stud;
insert into stud values(12,'sss',40);
select * from stud;
insert into stud(rollno,age) values(15,34);

show create table stud;

alter table stud add phone bigint default 1111;
desc stud;
insert into stud values(22,'qqq',36,67868);
select * from stud;
insert into stud(rollno,age) values(23,36);
select * from stud;



insert into stud values(30,'qqq',36,67868),(31,'asda',37,67868);


/* alter table tablename add (column1 datatype size, column2 datatype size);
alter table tablename modify columnname datatype size
alter table tablename modify column1 datatype size,modify column2 datatype size
alter table tablename drop column columnname;
alter table tablename drop column columnname,drop column columnname;

*/

-- alter table stud modify sname varchar(30) not null;

create table emps1 (empid int,empname varchar(30), sal int,deptno int);
desc emps1;
alter table emps1 add primary key(empid);
desc emps1;
-- drop the primary key constraint 
alter table emps1 drop primary key;
desc emps1;
alter table emps1 add dname varchar(30);
alter table emps1 add constraint c1 primary key(empid,dname);
desc emps1;

alter table emps1 add phone int unique;
-- to drop the unique constraint
alter table emps1 drop constraint phone;
desc emps1;
select constraint_name,table_name,constraint_type
from information_schema.table_constraints
where table_name='emps1';

-- make empname as not null
alter table emps1 modify empname varchar(30) not null;

desc emps1;

alter table emps1 add dob date not null;

desc emps1;

-- add not null constraint in phone
alter table emps1 modify phone int not null;
desc emps1;
-- add unique key constraint on phone
alter table emps1 add constraint c_unique_phone unique(phone);
desc emps1;
-- drop the unique constraint
alter table emps1 drop constraint c_unique_phone;
desc emps1;
-- drop the not null constraint from phone
alter table emps1 modify phone bigint;
desc emps1;


/* alter
1. add a column */
alter table emps1 add email_id varchar(30);
desc emps1;
-- add a new column with constraint definition
alter table emps1 
add designation varchar(30) check(designation in('manager','programmer','admin'));
-- add constraint(primary key, unique, check ,foreign key)
desc emps1;
select constraint_name,table_name,constraint_type
from information_schema.table_constraints
where table_name='emps1';
-- except not null constraint all other constraint 
-- can be added in alter if column already exists
-- 3. modify the datatype/size of 1 column
-- 4. modify the datatype of multiple  columns
desc emps1;
-- modify an existing coluumn as not null
-- example- > make the phone(already exist) column as not null
alter table emps1 modify phone bigint not null;

desc emps1;

create table emps2(empname varchar(20),age int);
desc emps2;
alter table emps2 add empid int primary key;

desc emps2;

-- 5. drop 1 column
-- 6. drop multiple columns in one alter command
-- 7. drop constraint
-- drop the primary key in emps2 table
desc emps2;
alter table emps2 drop primary key;
desc emps2;
desc emps1;
alter table emps1 drop primary key;
desc emps1;
-- make empid and dname as primary key again
alter table emps1 add primary key(empid,dname);
desc emps1;
-- drop the not null constraint on empno
alter table emps1 modify empname varchar(40);
desc emps1;
-- example 
-- add unique key constraint on phone
alter table emps1 add constraint c_unique_phone unique(phone);
desc emps1;
-- drop the unique constraint on phone
alter table emps1 drop constraint c_unique_phone;
desc emps1;
-- same drop constraint constraintname concept applicable with check constraint


-- example of foreign key creation
create table dept (dno int,dname varchar(30));
alter table dept add primary key(dno);
create table e1 (
empid int primary key, 
ename varchar(20),
dno int references dept(dno)
);
-- foreign key at table level

create table e2 (
empid int primary key, 
ename varchar(20),
dno int,
constraint fk1_dno_e2 foreign key(dno) references dept(dno)
);

-- drop the foreign key
alter table e2 drop foreign key fk1_dno_e2;


desc emps1;
-- i want make deptno of emps1 table as 
-- foreign key which will refer the dept table's dno column
alter table emps1 
add constraint c_fk_deptno_emps1 
foreign key(deptno) references dept(dno);
