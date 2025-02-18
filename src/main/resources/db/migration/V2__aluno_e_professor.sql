--
-- Migração V2
-- Criação da tabela tipo_pessoa
--

-- TIPOS DE PESSOAS
create table tipo_pessoa(
    id integer primary key,
    tipo_pessoa char(20) unique not null,

    -- auditoria
    criado_em timestamp default current_timestamp,
    salvo_em timestamp
);

-- cria os tipos para aluno e professor
insert into tipo_pessoa values
(0, 'Indefinido'),(1, 'Aluno'), (2, 'Professor');

-- adiciona o campo tipo_pessoa em pessoas
alter table pessoas add tipo_pessoa  integer not null default 0 references tipo_pessoa;

-- atualiza os registros de alunos e professores
update pessoas set tipo_pessoa=1 where eh_aluno=true;
update pessoas set tipo_pessoa=2 where eh_professor=true;

-- remove os campos eh_aluno e eh_professor
alter table pessoas drop column eh_aluno, drop column eh_professor;
