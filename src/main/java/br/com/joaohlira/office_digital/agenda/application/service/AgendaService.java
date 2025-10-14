package br.com.joaohlira.office_digital.agenda.application.service;

import br.com.joaohlira.office_digital.agenda.application.api.AgendaListResponse;
import br.com.joaohlira.office_digital.agenda.application.api.AgendaRequest;
import br.com.joaohlira.office_digital.agenda.application.api.AgendaResponse;

import java.util.List;

public interface AgendaService {
    AgendaResponse criaNovoCompromisso(AgendaRequest agendaRequest);

    List<AgendaListResponse> buscaCompromissos();
}
