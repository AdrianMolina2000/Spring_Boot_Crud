CREATE DATABASE banco
GO

drop table if exists cheque go
drop table if exists chequera go
drop table if exists cliente go
drop table if exists cuenta go

create table cheque (
    id int identity constraint cheque_pk primary key,
    lugar varchar(100),
    fecha_Canje date,
    total decimal,
    destinatario varchar(100),
    estado char(1) not null,
    id_chequera int not null
)
go

create table chequera (
    id int identity constraint chequera_pk primary key,
    cantidad int not null,
    fecha_Creacion date not null,
    estado char(1) not null,
    id_cliente int not null
)
go

create table cliente (
    id int identity constraint cliente_pk primary key,
    nombres varchar(100) not null,
    direccion varchar(100) not null,
    telefono varchar(20) not null,
    estado char(1) not null,
)
go

create table cuenta (
    id int identity constraint cuenta_pk primary key,
    tipo int not null,
    total decimal not null,
    fecha_creacion date not null,
    estado char(1) not null,
    id_cliente int not null
)
go

ALTER TABLE cuenta ADD CONSTRAINT cuenta_cliente_FK FOREIGN KEY (id_cliente)
REFERENCES cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE chequera ADD CONSTRAINT chequera_cliente_FK FOREIGN KEY (id_cliente)
REFERENCES cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE cheque ADD CONSTRAINT cheque_chequera_FK FOREIGN KEY (id_chequera) 
REFERENCES chequera (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO