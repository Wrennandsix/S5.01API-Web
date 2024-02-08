DROP DATABASE IF EXISTS bd_CRUD_BranchOffice;

create database bd_CRUD_BranchOffice;
use bd_CRUD_BranchOffice;

create table branch_offices(
id int primary key auto_increment,
`name` varchar(80) not null,
country varchar(80) not null
);

insert into branch_offices(`name`, country) values 
("Barcelona Bank","España");
insert into branch_offices(`name`, country) values 
("China Bank","China");
insert into branch_offices(`name`, country) values 
("Pepe Bank","Francia");
insert into branch_offices(`name`, country) values 
("Russian Bank ","Russia");