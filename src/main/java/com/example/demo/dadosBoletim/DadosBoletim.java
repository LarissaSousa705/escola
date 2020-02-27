package com.example.demo.dadosBoletim;

import com.example.demo.aluno.Aluno;

import javax.persistence.*;

@Entity(name = "dados_boletim")
public class DadosBoletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "notas", nullable = false)
    private Double notas;
    @Column(name = "disciplina", nullable = false, length = 50)
    private String disciplina;
    @Column(name = "periodo", nullable = false, length = 50)
    private String periodo;
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno aluno;
    @Column(name = "notas_um", nullable = false)
    private Double notasUm;
    @Column(name = "notas_dois", nullable = false)
    private Double notasDois;
    @Column(name = "media", nullable = false)
    private Double media;

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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getNotasUm() {
        return notasUm;
    }

    public void setNotasUm(Double notasUm) {
        this.notasUm = notasUm;
    }

    public Double getNotasDois() {
        return notasDois;
    }

    public void setNotasDois(Double notasDois) {
        this.notasDois = notasDois;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "DadosBoletim{" +
                "id=" + id +
                ", notas=" + notas +
                ", disciplina='" + disciplina + '\'' +
                ", periodo='" + periodo + '\'' +
                ", matriculaAluno=" + aluno.getMatriculaAluno() +
                ", notasUm=" + notasUm +
                ", notasDois=" + notasDois +
                ", media=" + media +
                '}';
    }
}
