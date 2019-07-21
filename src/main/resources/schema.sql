CREATE TABLE employee
(
 employeeName varchar(100) NOT NULL,
 employeeId varchar(11) NOT NULL ,
 employeeAddress varchar(100) DEFAULT NULL,
 employeeEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (employeeId)
);

create table users(
  username varchar(100) not null,
  useraddress varchar(100) not null,
  useremail varchar(100) not null,
  userpassword varchar(100) not null,
  primary key (username)
);

create table contact(
  name varchar(100) not null,
  email varchar(100) not null,
  message varchar(100) not null
);


create table VisitorDetails(
   ip varchar(200) not null,
   city varchar(100) not null,
   latitude varchar(100) not null,
   longitude varchar(100) not null
);
