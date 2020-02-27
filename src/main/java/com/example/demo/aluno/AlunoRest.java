package com.example.demo.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aluno")
public class AlunoRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoRest.class);

    private final AlunoService alunoService;

    @Autowired
    public AlunoRest(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoDTO save(@RequestBody AlunoDTO alunoDTO) {
        LOGGER.info("Recebendo solicitação de persistência do aluno...");
        LOGGER.debug("Payload: {}", alunoDTO);
        return this.alunoService.save(alunoDTO);
    }

    @PutMapping("/{ID}")
    public AlunoDTO update(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        LOGGER.info("Recebendo solicitação de persistência do aluno...");
        LOGGER.debug("Payload: {}", alunoDTO);

        return this.alunoService.update(alunoDTO, id);
    }

    @DeleteMapping("/{ID}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo delete para aluno de ID: [{}]", id);

        this.alunoService.delete(id);
    }

    @GetMapping("/{matricula}")
    public AlunoDTO findByMatricula(@PathVariable(name = "matricula") String matricula) {
        return AlunoDTO.of(this.alunoService.findByMatriculas(matricula));
    }

    @GetMapping
    public List<Aluno> findAllAluno(){
        return alunoService.findAll();
    }
}
