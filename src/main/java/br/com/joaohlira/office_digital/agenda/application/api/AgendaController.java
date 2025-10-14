package br.com.joaohlira.office_digital.agenda.application.api;

import br.com.joaohlira.office_digital.agenda.application.service.AgendaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AgendaController implements AgendaAPI {

    private final AgendaService agendaService;

    @Override
    public AgendaResponse agendaCompromisso(AgendaRequest agendaRequest) {
        log.info("[start] AgendaController - agendaCompromisso");
        AgendaResponse comprimissoAgendado = agendaService.criaNovoCompromisso(agendaRequest);
        log.debug("[finish] AgendaController - agendaCompromisso");
        return comprimissoAgendado;
    }

    @Override
    public List<AgendaListResponse> buscaCompromissosPorData() {
        log.info("[start] AgendaController - buscaCompromissosPorData");
        List<AgendaListResponse> compromissos = agendaService.buscaCompromissos();
        log.debug("[finish] AgendaController - buscaCompromissosPorData");
        return compromissos;
    }
}
