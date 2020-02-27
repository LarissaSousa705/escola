package com.example.demo.dadosBoletim;

import javax.validation.constraints.NotNull;

public class DadosBoletimDTO {

    private Long id;
    @NotNull
    private Double notas;
    @NotNull
    private String disciplina;
    @NotNull
    private String periodo;
    @NotNull
    private Long aluno;
    @NotNull
    private Double notasUm;
    @NotNull
    private Double notasDois;
    @NotNull
    private Double media;

    public DadosBoletimDTO() {
    }

    public DadosBoletimDTO(Long id, @NotNull Double notas, @NotNull String disciplina, @NotNull String periodo, @NotNull Long aluno, @NotNull Double notasUm, @NotNull Double notasDois, @NotNull Double media) {
        this.id = id;
        this.notas = notas;
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.aluno = aluno;
        this.notasUm = notasUm;
        this.notasDois = notasDois;
        this.media = media;
    }

    public static DadosBoletimDTO of(DadosBoletim dadosBoletim) {
        return new DadosBoletimDTO(
                dadosBoletim.getId(),
                dadosBoletim.getNotas(),
                dadosBoletim.getDisciplina(),
                dadosBoletim.getPeriodo(),
                dadosBoletim.getAluno().getId(),
                dadosBoletim.getNotasUm(),
                dadosBoletim.getNotasDois(),
                dadosBoletim.getMedia()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNotas() {
        return notas;
    }

    public void setNotas(Double notas) {
        this.notas = notas;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getAluno() {
        return aluno;
    }

    public void setAluno(Long aluno) {
        this.aluno = aluno;
    }

    public Double getNotasUm() {
        return notasUm;
    }

    public void setNotasUm(Double notasUm) {
        this.notasUm = notasUm;
    }

    public void setNotasDois(Double notasDois) {
        this.notasDois = notasDois;
    }

    public double getNotasDois() {
        return notasDois;
    }

    public void setNotasDois(double notasDois) {
        this.notasDois = notasDois;
        this.calculoMedia();
    }

    public double getMedia() {
        return calculoMedia();
    }

    public void setMedia() {
        this.media = (this.notas + this.notasUm + this.notasDois) / 3;
    }

    public double calculoMedia() {
        this.media = (this.notas + this.notasUm + this.notasDois) / 3;
        return this.media;
    }


    @Override
    public String toString() {
        return "DadosBoletimDTO{" +
                "id=" + id +
                ", notas=" + notas +
                ", disciplina='" + disciplina + '\'' +
                ", periodo='" + periodo + '\'' +
                ", aluno='" + aluno + '\'' +
                ", notasUm=" + notasUm +
                ", notasDois=" + notasDois +
                ", media=" + media +
                '}';
    }
}
