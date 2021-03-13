create database ESamparkaFlights;
show databases;
use ESamparkaFlights;
create table markets(
id int not null auto_increment,
code varchar (25) not null,
country varchar (35) not null,
primary key(id)
);
show tables;
describe markets;

select * from markets;