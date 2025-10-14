package br.com.joaohlira.office_digital.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/agenda")
public interface AgendaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AgendaResponse agendaCompromisso(@RequestBody AgendaRequest agendaRequest);

    @GetMapping("/busca-por-data/")
    @ResponseStatus(HttpStatus.OK)
    List<AgendaListResponse> buscaCompromissosPorData();
}
