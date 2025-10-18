package br.com.joaohlira.office_digital.compromisso.application.api;

import br.com.joaohlira.office_digital.compromisso.application.service.CompromissoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class CompromissoController implements CompromissoAPI {

    private final CompromissoService compromissoService;

    @Override
    public CompromissoResponse agendaCompromisso(CompromissoRequest agendaRequest) {
        log.info("[start] CompromissoController - agendaCompromisso");
        CompromissoResponse comprimissoAgendado = compromissoService.criaNovoCompromisso(agendaRequest);
        log.debug("[finish] CompromissoController - agendaCompromisso");
        return comprimissoAgendado;
    }

    @Override
    public List<CompromissoListResponse> buscaCompromissosPorData(LocalDate data) {
        log.info("[start] CompromissoController - buscaCompromissosPorData");
        List<CompromissoListResponse> compromissos = compromissoService.buscaCompromissos(data);
        log.debug("[finish] CompromissoController - buscaCompromissosPorData");
        return compromissos;
    }

    @Override
    public void atualizaCompromisso(UUID idCompromisso, CompromissoAltecacaoRequest alteracaoRequest) {
        log.info("[start] CompromissoController - atualizaCompromisso");
        compromissoService.atualizaCompromisso(idCompromisso, alteracaoRequest);
        log.debug("[finish] CompromissoController - atualizaCompromisso");
    }
}
