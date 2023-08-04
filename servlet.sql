use express;

create table book(
bname varchar(50),
aname varchar(50),
price int,
qty int 

);
insert into book values('WebPage','ZUcker',1500,25);


select * from book;

create table adminlogin(
user varchar(50),
pass varchar(30)



);
insert into adminlogin values('admin','test@123');
insert into adminlogin values('yatin','test@222');
insert into adminlogin values('admin3','test@333');
insert into adminlogin values('sanket','test@444');
select * from adminlogin;


create table employee(
id long ,
name varchar(50),
age int,
city varchar(30)
);

insert into employee values(101,'shital',34,'kalyan');
select * from employee;
select * from books;

create table books(
isbn int,
bname varchar(50),
aname varchar(50),
price int,
qty int 

);