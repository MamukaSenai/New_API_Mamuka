DROP DATABASE bd_mamuka;

CREATE DATABASE bd_mamuka;

USE bd_mamuka;

drop table tb_usuario;

drop table tb_projeto;

drop table tb_tarefa;

select * from tb_projeto;

DELETE FROM tb_usuario;

CREATE TABLE tb_usuario(
id BINARY(16) NOT NULL,
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(255) NOT NULL UNIQUE,
data_nascimento DATE,
status_atividade BOOL,
departamento VARCHAR(255) NOT NULL,
perfil VARCHAR(255) NOT NULL,
cargo VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
senha VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (id)
);

SELECT * FROM tb_usuario;

DROP TABLE tb_projeto;

CREATE TABLE tb_projeto (
id BINARY(16) NOT NULL,
nome_projeto VARCHAR(255) NOT NULL,
status_projeto VARCHAR(255) NOT NULL,
data_inicio DATE,
data_conclusao DATE,
-- responsavel VARCHAR(255),-- 
id_gestor BINARY(16),
PRIMARY KEY (id),
FOREIGN KEY (id_gestor) REFERENCES tb_usuario (id)
);

DROP TABLE tb_tarefa;

CREATE TABLE tb_tarefa (
id BINARY(16) NOT NULL,
nome_tarefa VARCHAR(255) NOT NULL,
status_tarefa VARCHAR(255) NOT NULL,
data_inicio DATE,
data_conclusao DATE,
id_responsavel BINARY(16),
id_projeto BINARY(16) NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (id_responsavel) REFERENCES tb_usuario (id),
FOREIGN KEY (id_projeto) REFERENCES tb_projeto (id)
);

SELECT * FROM tb_usuario;

SELECT * FROM tb_projeto;

INSERT INTO tb_projeto (id, nome_projeto, status_projeto, data_inicio, data_conclusao, id_usuario) VALUES
(UUID_TO_BIN(UUID()), 'Projeto A', 'Em Andamento', '2023-01-15', '2023-03-30', UUID_TO_BIN('59d5f9f9-6826-4818-bb65-e39a7aac1158')),
(UUID_TO_BIN(UUID()), 'Projeto B', 'Concluído', '2022-11-01 10:30:00', '2023-01-10 15:45:00', UUID_TO_BIN('24fe413e-17d1-4f9c-a1f5-f092d21bffbb'));