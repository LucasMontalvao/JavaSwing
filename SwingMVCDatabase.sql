create database Cadastros;

use Cadastros;

create table Cadastro(
	id integer primary key auto_increment,
    nome varchar(250),
    sobrenome varchar(250),
    email varchar(250),
    cpf varchar(11),
    rg varchar(7),
    senha varchar(250),
    usuario varchar(250),
    dt_nascimento date
);