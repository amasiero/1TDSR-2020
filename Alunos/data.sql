create table tb_aluno (
	id number not null primary key,
	rm number not null,
	nome varchar2(100) not null,
	ativo number(1) default 0,
	nota1 number(3,1) default 0,
	nota2 number(3,1) default 0
);

create sequence sq_aluno increment by 1 start with 1 nocycle order;

select * from tb_aluno;