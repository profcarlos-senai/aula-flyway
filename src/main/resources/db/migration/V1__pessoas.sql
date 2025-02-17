--
-- Migração V1
-- Criação da tabela de pessoas
--

-- PESSOAS
create table pessoas(
    id bigserial primary key,
    nome varchar(100) not null,
    data_nasc date,

    -- endereço
    endereco varchar(255),
    cidade varchar(50),
    uf char(2),
    cep numeric(8),

    -- documentos
    identidade varchar(20),
    cpf numeric(11),

    -- contato
    fone1 numeric(11),
    fone2 numeric(11),
    email varchar(50),

    -- dados do aluno
    eh_aluno boolean default false,
    nome_resp varchar(100),
    cpf_resp numeric(11),
    fone_resp numeric(11),

    -- dados do professor
    eh_professor boolean default false,
    graduacao varchar(255),
    mestrado varchar(255),
    doutorado varchar(255),

    -- auditoria
    criado_em timestamp default current_timestamp,
    salvo_em timestamp
);


--
-- DADOS DE TESTE
--
INSERT INTO pessoas (
    nome, eh_professor, eh_aluno, graduacao, mestrado, doutorado,
    nome_resp, cpf_resp, fone_resp,
    endereco, cidade, uf, cep, identidade, fone1, fone2, email, data_nasc
) VALUES
-- Professores (eh_professor = true, eh_aluno = false)
('Carlos Silva', true, false, 'Engenharia de Software', 'Mestrado em Computação', NULL,
 NULL, NULL, NULL,
 'Rua das Flores, 123', 'São Paulo', 'SP', 12345678, 'RG12345678', '11988887777', '11999998888', 'carlos@email.com', '1985-03-15'),

('Mariana Souza', true, false, 'Matemática', 'Mestrado em Estatística', NULL,
 NULL, NULL, NULL,
 'Av. Brasil, 456', 'Rio de Janeiro', 'RJ', 87654321, 'RG87654321', '21977776666', '21966665555', 'mariana@email.com', '1992-07-22'),

-- Alunos (eh_professor = false, eh_aluno = true)
('João Pereira', false, true, NULL, NULL, NULL,
 'Ana Pereira', 12345678900, 11987654321,
 'Rua A, 12', 'Belo Horizonte', 'MG', 30123456, 'RG11223344', '31955554444', '31944443333', 'joao@email.com', '2010-05-10'),

('Fernanda Lima', false, true, NULL, NULL, NULL,
 'Carlos Lima', 23456789011, 21976543210,
 'Rua B, 34', 'Curitiba', 'PR', 80234567, 'RG22334455', '41966665555', '41977776666', 'fernanda@email.com', '2008-09-18'),

('Pedro Rocha', false, true, NULL, NULL, NULL,
 'Mariana Rocha', 34567890122, 31965432109,
 'Rua C, 56', 'Salvador', 'BA', 40123456, 'RG33445566', '71988887777', '71999998888', 'pedro@email.com', '2006-12-25'),

('Ana Beatriz', false, true, NULL, NULL, NULL,
 'Fernanda Beatriz', 45678901233, 41954321098,
 'Rua D, 78', 'Porto Alegre', 'RS', 90234567, 'RG44556677', '51911112222', '51922223333', 'ana@email.com', '2012-04-30'),

('Lucas Oliveira', false, true, NULL, NULL, NULL,
 'José Oliveira', 56789012344, 51943210987,
 'Rua E, 90', 'Fortaleza', 'CE', 60123456, 'RG55667788', '85933334444', '85944445555', 'lucas@email.com', '1999-11-03'),

('Carla Mendes', false, true, NULL, NULL, NULL,
 'Beatriz Mendes', 67890123455, 61932109876,
 'Rua F, 101', 'Recife', 'PE', 50123456, 'RG66778899', '81955556666', '81966667777', 'carla@email.com', '2005-06-20'),

('Eduardo Santos', false, true, NULL, NULL, NULL,
 'Paulo Santos', 78901234566, 71921098765,
 'Rua G, 111', 'Manaus', 'AM', 69012345, 'RG77889900', '92977778888', '92988889999', 'eduardo@email.com', '1998-02-14'),

-- Professor e aluno ao mesmo tempo (eh_professor = true, eh_aluno = true)
('Ricardo Almeida', true, true, 'Física', 'Mestrado em Física Aplicada', NULL,
 'Patrícia Almeida', 89012345677, 81910987654,
 'Rua H, 222', 'Florianópolis', 'SC', 88012345, 'RG88990011', '48999990000', '48988887777', 'ricardo@email.com', '1980-08-08');
