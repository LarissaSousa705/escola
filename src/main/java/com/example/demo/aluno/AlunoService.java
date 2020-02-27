package com.example.demo.aluno;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);

    private final IAlunoRepository iAlunoRepository;

    public AlunoService(IAlunoRepository iAlunoRepository) {
        this.iAlunoRepository = iAlunoRepository;
    }

    public AlunoDTO save(AlunoDTO alunoDTO){
        LOGGER.info("Salvando aluno");
        LOGGER.debug("Aluno: {}", alunoDTO);

        Aluno aluno = new Aluno();

        aluno.setId(alunoDTO.getId());
        aluno.setNomeAluno(alunoDTO.getNomeAluno());
        aluno.setCpfAluno(alunoDTO.getCpfAluno());
        aluno.setTurmaAluno(alunoDTO.getTurmaAluno());
        aluno.setDataNasciAluno(alunoDTO.getDataNasciAluno());
        aluno.setMatriculaAluno(alunoDTO.getMatriculaAluno());

        aluno = this.iAlunoRepository.save(aluno);

        return AlunoDTO.of(aluno);
    }

    public AlunoDTO update(AlunoDTO alunoDTO, Long id) {
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno alunoExistente = alunoOptional.get();


            LOGGER.info("Atualizando aluno... id: [{}]", alunoExistente.getId());
            LOGGER.debug("Payload: {}", alunoDTO);
            LOGGER.debug("Aluno Existente: {}", alunoExistente);

            alunoExistente.setId(alunoDTO.getId());
            alunoExistente.setNomeAluno(alunoDTO.getNomeAluno());
            alunoExistente.setCpfAluno(alunoDTO.getCpfAluno());
            alunoExistente.setTurmaAluno(alunoDTO.getTurmaAluno());
            alunoExistente.setDataNasciAluno(alunoDTO.getDataNasciAluno());
            alunoExistente.setMatriculaAluno(alunoDTO.getMatriculaAluno());

            this.iAlunoRepository.save(alunoExistente);
            return AlunoDTO.of(alunoExistente);
        }
        throw new IllegalArgumentException(String.format("ID %s não existente", id));

    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para aluno de ID : [{}]", id);

        this.iAlunoRepository.deleteById(id);
    }

    public Aluno findById(Long id) {
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            return alunoOptional.get();
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Aluno findByMatriculas(String matricula) {
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findByMatriculaAluno(matricula);

        if (alunoOptional.isPresent()) {
            return alunoOptional.get();
        }
        throw new IllegalArgumentException("Matrícula não existe");
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = this.iAlunoRepository.findAll();
        return alunos;
    }
}
