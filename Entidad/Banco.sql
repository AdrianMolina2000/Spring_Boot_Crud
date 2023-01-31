CREATE DATABASE banco
GO

drop table if exists chequera_cheque go
drop table if exists cheque go
drop table if exists chequera go
drop table if exists cliente go
drop table if exists cliente_chequera go
drop table if exists cliente_cuenta go
drop table if exists cuenta go

create table cheque (
    id int identity constraint cheque_pk primary key,
    lugar varchar not null,
    fecha_Canje date not null,
    total decimal not null,
    destinatario varchar not null
)
go

create table chequera (
    id int identity constraint chequera_pk primary key,
    cantidad int not null,
    fecha_Creacion date not null
)
go

create table chequera_cheque (
    id int identity constraint chequera_cheque_pk primary key,
    id_chequera int not null,
    id_cheque int not null,
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

create table cliente_chequera(
    id int identity constraint cliente_chequera_pk primary key,
    id_cliente int not null,
    id_chequera int not null,
)
go

create table cliente_cuenta(
    id int identity constraint cliente_cuenta_pk primary key,
    id_cliente int not null,
    id_cuenta int not null,
)
go

create table cuenta (
    id int identity constraint cuenta_pk primary key,
    tipo int not null,
    total decimal not null,
    fecha_creacion date not null,
)
go

ALTER TABLE chequera_cheque ADD CONSTRAINT chequera_cheque_chequera_FK FOREIGN KEY (id_chequera)
REFERENCES chequera (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE chequera_cheque ADD CONSTRAINT chequera_cheque_cheque_FK FOREIGN KEY (id_cheque)
REFERENCES cheque (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE cliente_chequera ADD CONSTRAINT cliente_chequera_cliente_FK FOREIGN KEY (id_cliente)
REFERENCES cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE cliente_chequera ADD CONSTRAINT cliente_chequera_chequera_FK FOREIGN KEY (id_chequera)
REFERENCES chequera (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE cliente_cuenta ADD CONSTRAINT cliente_cuenta_cliente_FK FOREIGN KEY (id_cliente)
REFERENCES cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE cliente_cuenta ADD CONSTRAINT cliente_cuenta_cuenta_FK FOREIGN KEY (id_cuenta) 
REFERENCES cuenta (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO