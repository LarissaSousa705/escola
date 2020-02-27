create table aluno
(
    id BIGINT           IDENTITY (1,1) PRIMARY KEY NOT NULL,
    nome_aluno          VARCHAR(50)                NOT NULL,
    cpf_aluno           VARCHAR(11)                NOT NULL,
    turma_aluno         VARCHAR(50)                NOT NULL,
    data_nasci_aluno    DATE                       NOT NULL,
    matricula_aluno     VARCHAR(50)                NOT NULL
);