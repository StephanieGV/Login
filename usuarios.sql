drop database if exists usuarios;
create database usuarios;
use usuarios;
create table usuario(
id int primary key not null auto_increment,
nombre varchar(50) not null,
password varchar(20) not null);
Insert into usuario values(null,"Stephanie", "1234");