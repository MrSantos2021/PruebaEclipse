use santos1_pruebadb;
drop table empresatbl;
truncate table empresatbl;
describe customer;
show tables;
/*Creación de una nueva empresa o una corporación*/
create table empresatbl(
id_emp int(3) not null auto_increment,
nombre_emp varchar(25) not null,
ruc_emp varchar(14) not null,
act_emp varchar(13) not null,
tam_emp varchar(12) not null,
cap_emp varchar(7) not null,
amb_emp varchar(13) not null,
benef_emp varchar(9) not null,
jur_emp varchar(40)not null,
prod_emp varchar(18) not null,
soc_emp varchar(70)not null,
ce_emp boolean not null,
subcorp int(3) not null,
primary key (id_emp)
);
select * from empresatbl;
truncate table empresatbl;

/*Insertar un dato*/
insert into empresatbl(nombre_emp, ruc_emp, act_emp, tam_emp, cap_emp, amb_emp, benef_emp, jur_emp, prod_emp, soc_emp, ce_emp, subcorp) values('Def S.A.', '0999999999991', 'Agrícola', 'Microempresa', 'Privado', 'Local', 'Sin_Lucro', 'Unipersonal', 'Bienes', 'Aaa, Bbb, Ccc', 0, 1);
truncate table empresatbl;
/*Para combo box de formulario Agregar nueva empresa*/
select nombre_emp from empresatbl;
/*Seleccionar el ruc de dicha empresa*/
select ruc_emp from empresatbl where nombre_emp = 'Santos S.A.';
/**/
select nombre_emp from empresatbl order by id_emp desc limit 1;
select id_emp from empresatbl where nombre_emp = 'Def S.A.';
/*Tabla de registro de login ENTRADA Y SALIDA*/
create table reg_history(
id_history int not null auto_increment,
nombre_emp varchar(25) not null,
nombre_local varchar(25) not null,
nombre_user varchar(25) not null,
hora_ini time not null,
fecha_ini date not null,
hora_fin time null,
fecha_fin date null,
primary key (id_history)
);
/*La hora y fecha de servidor como el de local son de diferentes valores*/
select * from reg_history;
select id_emp from empresatbl where nombre_emp = 'Santos S.A.';
truncate table reg_history;
drop table reg_history;
/*Cuando usa hora del servidor remoto se utiliza subtime()*/
select subtime(current_time(), '05:00:00');
insert into reg_history1 (nombre_local, hora_ini, fecha_ini, hora_fin, fecha_fin) values('Local 1', current_time(), current_date(), null, null);

insert into reg_history (nombre_emp, nombre_local, hora_ini, fecha_ini, hora_fin, fecha_fin) values('Def S.A.', 'Local 1', subtime(current_time(), '05:00:00'), current_date(), null, null);
update reg_history set hora_fin = subtime(current_time(), '05:00:00'), fecha_fin = current_date() where id_history = 2;

insert into reg_history (nombre_emp, nombre_local, nombre_user, hora_ini, fecha_ini, hora_fin, fecha_fin) values('Abc S.A.','Local 1', 'User 1', cast('22:45:00' as time), cast('2021-09-17' as date), null, null);
update reg_history2 set hora_fin = cast('13:30:00' as time), fecha_fin = cast('2021-09-19' as date) where id_history = (select id_history from reg_history2 order by id_history desc limit 1) and nombre_local = 'Local 1';

update reg_history set hora_fin = cast('13:30:00' as time), fecha_fin = cast('2021-09-19' as date) where nombre_emp = 'Abc S.A.' and nombre_local = 'Local 1' and id_history = 1;
select id_history from reg_history order by id_history desc limit 1;

create table localtbl(
idLocal tinyint not null auto_increment,
nombre_emp varchar(25) not null,
tipoLocal varchar(10) not null,
nombreLocal varchar(25) not null,
provLocal varchar(50) not null,
ciudadLocal varchar(40) not null,
dirLocal varchar(75) not null,
telf1Local varchar(10) null,
telf2Local varchar(10) null,
primary key (idLocal)
);
drop table localtbl;
truncate table localtbl;
select * from localtbl;
insert into localtbl (nombre_emp, tipoLocal, nombreLocal, provLocal, ciudadLocal, dirLocal, telf1Local, telf2Local) values('Abc S.A.','Matriz', 'Local 1', 'Guayas', 'Guayaquil', 'Avenida 1 y calle 1', '2444444', '2555555');
update localtbl set tipoLocal='A', nombreLocal = 'A', provLocal ='A', ciudadLocal='A', dirLocal='A', telf1Local='A', telf2Local='A' where nombre_emp = 'A' and nombreLocal='A';
select nombreLocal from localtbl where nombre_emp = 'Santos y Asociados S.A.';
select idLocal from localtbl order by idLocal desc limit 1;
select idLocal from localtbl where nombre_emp='Santos y Asociados S.A.' and nombreLocal = 'Zona Rosa';
select idLocal from localtbl where nombre_emp = 'Santos y Asociados S.A.' and nombreLocal = 'Zona Rosa';

create table funciontbl(
id_funcion tinyint not null auto_increment,
nombre_emp varchar(25) not null,
name_funcion varchar(25) not null,
category_funcion varchar(1) not null,
descrip_funcion varchar(50) null,
primary key (id_funcion)
);
select * from funciontbl;
select name_funcion from funciontbl where nombre_emp = 'Abc' and (category_funcion = 'A' or category_funcion = 'B');
truncate table funciontbl;
insert into funciontbl(nombre_emp, name_funcion, category_funcion, descrip_funcion) values('Abc', 'Funcion 1', 'A', 'Realiza a,b, c.');
