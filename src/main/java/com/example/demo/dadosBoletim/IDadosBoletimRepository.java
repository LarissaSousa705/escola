package com.example.demo.dadosBoletim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface IDadosBoletimRepository extends JpaRepository<DadosBoletim, Long> {

    List<DadosBoletim> findAllByAluno_MatriculaAluno(String matriculaAluno);
}
