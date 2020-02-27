package com.example.demo.aluno;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_aluno", nullable = false, length = 50)
    private String nomeAluno;
    @Column(name = "cpf_aluno", nullable = false, length = 11)
    private String cpfAluno;
    @Column(name = "turma_aluno", nullable = false, length = 50)
    private String turmaAluno;
    @Column(name = "data_nasci_aluno", nullable = false, length = 50)
    private Date dataNasciAluno;
    @Column(name = "matricula_aluno", nullable = false, length = 50)
    private String matriculaAluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public String getTurmaAluno() {
        return turmaAluno;
    }

    public void setTurmaAluno(String turmaAluno) {
        this.turmaAluno = turmaAluno;
    }

    public Date getDataNasciAluno() {
        return dataNasciAluno;
    }

    public void setDataNasciAluno(Date dataNasciAluno) {
        this.dataNasciAluno = dataNasciAluno;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", cpfAluno='" + cpfAluno + '\'' +
                ", turmaAluno='" + turmaAluno + '\'' +
                ", dataNasciAluno=" + dataNasciAluno +
                ", matriculaAluno='" + matriculaAluno + '\'' +
                '}';
    }
}


