package com.example.demo.dadosBoletim;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/dadosboletim")
public class DadosBoletimRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DadosBoletimRest.class);

    private final DadosBoletimService dadosBoletimService;

    @Autowired
    public DadosBoletimRest(DadosBoletimService dadosBoletimService) {
        this.dadosBoletimService = dadosBoletimService;
    }


    @PostMapping
    public DadosBoletimDTO save(@RequestBody DadosBoletimDTO dadosBoletimDTO) {
        LOGGER.info("Recebendo solicitação de persistência de notas...");
        LOGGER.debug("Payaload: {}", dadosBoletimDTO);

        return this.dadosBoletimService.save(dadosBoletimDTO);
    }
    @PutMapping("/{id}")
    public DadosBoletimDTO udpate(@PathVariable("id") Long id, @RequestBody DadosBoletimDTO dadosBoletimDTO) {
        LOGGER.info("Recebendo Update para notas de ID: {}", id);
        LOGGER.debug("Payload: {}", dadosBoletimDTO);

        return this.dadosBoletimService.update(dadosBoletimDTO, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para notas de ID: {}", id);

        this.dadosBoletimService.delete(id);
    }
    @GetMapping("/report/{matricula}")
    public void genrateReport(@PathVariable("matricula") String matricula, HttpServletResponse response) throws IOException, JRException {
        this.dadosBoletimService.exportReport(matricula, response);
    }
}