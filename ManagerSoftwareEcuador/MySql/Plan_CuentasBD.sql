create table planCtastbl(
idCta int not null auto_increment,
nameCta varchar(60) not null,
tipoCta varchar(50) not null,
subCta varchar(25) not null,
descripCta varchar(100) null,
primary key(idCta)
);
select * from planCtastbl;
update planCtastbl set idCta = 58 where idCta = 60;
delete from planCtastbl where idCta = 59;
insert into planCtastbl(nameCta, tipoCta, subCta, descripCta) values('Depreciaciones','Gastos','Gastos De Ventas','Otros pagos');
insert into planCtastbl(nameCta, tipoCta, subCta, descripCta) values('Cuentas por pagar','Pasivos','Pasivo No Corriente','Acreedores a quienes debe la empresa a buena cta.');