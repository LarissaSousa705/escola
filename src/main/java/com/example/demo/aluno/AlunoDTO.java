package com.example.demo.aluno;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AlunoDTO {

    @NotNull
    private Long id;
    @NotNull
    private String nomeAluno;
    @NotNull
    @CPF
    private String cpfAluno;
    @NotNull
    private String turmaAluno;
    @NotNull
    private Date dataNasciAluno;
    @NotNull
    private String matriculaAluno;

    public AlunoDTO() {
    }

    public AlunoDTO(@NotNull Long id, @NotNull String nomeAluno, @NotNull @CPF String cpfAluno, @NotNull String turmaAluno, @NotNull Date dataNasciAluno, @NotNull String matriculaAluno) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.turmaAluno = turmaAluno;
        this.dataNasciAluno = dataNasciAluno;
        this.matriculaAluno = matriculaAluno;
    }

    public static AlunoDTO of(Aluno aluno){
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNomeAluno(),
                aluno.getCpfAluno(),
                aluno.getTurmaAluno(),
                aluno.getDataNasciAluno(),
                aluno.getMatriculaAluno()
        );
    }

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
        return "AlunoDTO{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", cpfAluno='" + cpfAluno + '\'' +
                ", turmaAluno='" + turmaAluno + '\'' +
                ", dataNasciAluno=" + dataNasciAluno +
                ", matriculaAluno='" + matriculaAluno + '\'' +
                '}';
    }
}
