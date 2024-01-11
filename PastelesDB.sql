drop database if exists ProyectoPasteles;
create database ProyectoPasteles;
use ProyectoPasteles;

create table UsuarioPasteles(
Id_usuariow int(3) not null auto_increment primary key,
Nombre varchar(30),
Apellidos varchar(30),
Correo varchar(60),
Contra varchar(30)
);
