create database User_Management;

use User_Management;

create table user_
(id int primary key not null auto_increment,
firstname varchar(30),
lastname varchar(30),
username varchar(30),
password varchar(10));

select * from user_;

create table users_manage
(id int not null primary key auto_increment,
name varchar(50),
email varchar(30),
countries varchar(100),
userid int);

select * from users_manage;
