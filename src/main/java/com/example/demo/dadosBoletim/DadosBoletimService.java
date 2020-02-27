package com.example.demo.dadosBoletim;

import com.example.demo.aluno.AlunoService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DadosBoletimService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DadosBoletimService.class);

    private final IDadosBoletimRepository iDadosBoletimRepository;
    private final AlunoService alunoService;

    public DadosBoletimService(IDadosBoletimRepository iDadosBoletimRepository, AlunoService alunoService) {
        this.iDadosBoletimRepository = iDadosBoletimRepository;
        this.alunoService = alunoService;
    }

    public DadosBoletimDTO save(DadosBoletimDTO dadosBoletimDTO) {

        this.validateDisciplina(dadosBoletimDTO);
        this.validatePeriodo(dadosBoletimDTO);
        LOGGER.info("Salvando Nota");
        LOGGER.debug("Nota: {}", dadosBoletimDTO);

        DadosBoletim dadosBoletim = new DadosBoletim();
        dadosBoletim.setId(dadosBoletimDTO.getId());
        dadosBoletim.setNotas(dadosBoletimDTO.getNotas());
        dadosBoletim.setDisciplina(dadosBoletimDTO.getDisciplina());
        dadosBoletim.setPeriodo(dadosBoletimDTO.getPeriodo());
        dadosBoletim.setNotasUm(dadosBoletimDTO.getNotasUm());
        dadosBoletim.setNotasDois(dadosBoletimDTO.getNotasDois());
        dadosBoletim.setAluno(alunoService.findById(dadosBoletimDTO.getAluno()));
        dadosBoletim.setMedia(dadosBoletimDTO.getMedia());
        dadosBoletim = this.iDadosBoletimRepository.save(dadosBoletim);

        return DadosBoletimDTO.of(dadosBoletim);
    }

    public DadosBoletimDTO update(DadosBoletimDTO dadosBoletimDTO, Long id) {
        Optional<DadosBoletim> notasOptional = this.iDadosBoletimRepository.findById(id);
        if (notasOptional.isPresent()) {
            DadosBoletim dadosBoletim = notasOptional.get();

            LOGGER.info("Atualizando nota... id: [{}]", dadosBoletim.getId());
            LOGGER.debug("Payload: {}", dadosBoletimDTO);
            LOGGER.debug("Nota Existente: {}", dadosBoletim);

            dadosBoletim.setId(dadosBoletimDTO.getId());
            dadosBoletim.setNotas(dadosBoletimDTO.getNotas());
            dadosBoletim.setDisciplina(dadosBoletimDTO.getDisciplina());
            dadosBoletim.setPeriodo(dadosBoletimDTO.getPeriodo());
            dadosBoletim.setNotasUm(dadosBoletimDTO.getNotasUm());
            dadosBoletim.setNotasDois(dadosBoletimDTO.getNotasDois());
            dadosBoletim.setMedia(dadosBoletimDTO.getMedia());
            dadosBoletim.setAluno(alunoService.findById(dadosBoletimDTO.getAluno()));
            this.iDadosBoletimRepository.save(dadosBoletim);
            return DadosBoletimDTO.of(dadosBoletim);
        }
        throw new IllegalArgumentException(String.format("ID %s não existente", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para nota de ID: [{}]", id);
        this.iDadosBoletimRepository.deleteById(id);
    }

    private void validatePeriodo(DadosBoletimDTO dadosBoletimDTO) {
        switch (dadosBoletimDTO.getPeriodo()) {
            case "1° trimestre":
            case "Primeiro trimestre":
            case "2° trimestre":
            case "Segundo trimestre":
            case "3° trimestre":
            case "Terceiro trimestre":
                break;
            default:
                throw new IllegalArgumentException("Período não pode ser diferente de: 1° trimestre, Primeiro trimestre, 2° trimestre, Segundo trimestre," +
                        " 3° trimestre, Terceiro trimestre");
        }
    }

    private void validateDisciplina(DadosBoletimDTO dadosBoletimDTO) {
        switch (dadosBoletimDTO.getDisciplina()) {
            case "Língua Portuguesa":
            case "Matemática":
            case "Arte":
            case "Biologia":
            case "Educação Física":
            case "Filosofia":
            case "Física":
            case "Geografia":
            case "História":
            case "Língua Estrangeira - Inglês":
            case "Química":
            case "Sociologia":
                break;
            default:
                throw new IllegalArgumentException("Disciplina não pode ser diferente de: Língua Portuguesa, Matemática, Arte, Biologia, Educação Física, Filosofia, Geografia, História" +
                        " Língua Estrangeira - Inglês, Química, Sociologia");
        }
    }


    public void exportReport(String matricula, HttpServletResponse response) throws IOException, JRException {

        List<DadosBoletim> dadosBoletimList = iDadosBoletimRepository.findAllByAluno_MatriculaAluno(matricula);

        response.setContentType("text/pdf");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + "boletim " + "\"");

        File file = ResourceUtils.getFile("classpath:escola.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dadosBoletimList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Larissa");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        OutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
