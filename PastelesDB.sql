drop database if exists ProyectoPasteles;
create database ProyectoPasteles;
use ProyectoPasteles;

drop table if exists UsuarioPasteles;
create table UsuarioPasteles(
	Id_usuariow int(3) not null auto_increment primary key,
	Nombre varchar(60),
	Apellidos varchar(60),
	Correo varchar(60),
	Contra varchar(60)
);


use ProyectoPasteles;
drop procedure if exists GuardaUsuario;
delimiter **
create procedure GuardaUsuario( in nombreDAO varchar(60), in apellidoDAO varchar(60), in emailDAO varchar(60), in pswDAO varchar(60))
begin

INSERT INTO UsuarioPasteles(Nombre, Apellidos, Correo, Contra) 
values(nombreDAO, apellidoDAO, emailDAO, pswDAO);

end**