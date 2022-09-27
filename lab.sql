create database clubhouses;
use clubhouses;

use clubhouse;
create table adminlogin(
user varchar(50),
pass varchar(30)
);

insert into adminlogin values('admin','test@1');
insert into adminlogin values('yatin','test@2');
select * from adminlogin;

create table memberlogins(
aadharID int Not NUll,
pass varchar(30),
primary key (aadharID)
);

insert into memberlogins values(1,'test@1');
insert into memberlogins values(2,'test@2');

insert into memberlogins values(3,'test@3');
insert into memberlogins values(4,'test@4');

insert into memberlogins values(5,'test@5');
insert into memberlogins values(6,'test@6');
select * from memberlogins;

select * from memberdetail where aadharID=3;
delete from memberdetail where aadharID=6;

select * from memberdetail order by aadharID;
update memberdetail set email='abc@gmail.com',name='sachin',age=24,phone='2342354',
address='Noida' where aadharId=4;
create table memberdetail
(
aadharID int ,
email varchar(40) primary key,
name varchar(30),
age int (30),
phone varchar(30),
address varchar(30),
Foreign key (aadharID) references memberlogins(aadharID)
);