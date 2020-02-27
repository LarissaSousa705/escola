create table dados_boletim
(
    id BIGINT           IDENTITY (1,1)  PRIMARY KEY NOT NULL,
    notas               DECIMAL(4,2)    NOT NULL,
    notas_um            DECIMAL(4,2)    NOT NULL,
    notas_dois          DECIMAL(4,2)    NOT NULL,
    media               DECIMAL(4,2)    NOT NULL,
    disciplina          VARCHAR(50)     NOT NULL,
    periodo             VARCHAR(50)     NOT NULL,
    id_aluno            BIGINT          NOT NULL,
    CONSTRAINT fk_aluno_boletim FOREIGN KEY (id_aluno) REFERENCES aluno(id)


);

