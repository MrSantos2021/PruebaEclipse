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

create table diariogeneraltbl(
id_dg int not null auto_increment,
trans_dg int not null,
fecha_dg date not null,
cta_dg varchar(80) not null,
debe_dg decimal(9,2) not null,
haber_dg decimal(9,2)not null,
detalle_dg varchar(100) null,
primary key(id_dg)
);
insert diariogeneraltbl() values();
create table dg_auxtbl(
id_aux
trans
detalle
);
