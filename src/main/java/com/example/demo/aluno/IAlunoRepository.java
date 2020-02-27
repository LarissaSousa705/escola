package com.example.demo.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface IAlunoRepository extends JpaRepository<Aluno,Long> {
    Optional<Aluno> findByMatriculaAluno(String matricula);
}
