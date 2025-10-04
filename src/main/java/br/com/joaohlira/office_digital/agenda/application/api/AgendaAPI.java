package br.com.joaohlira.office_digital.agenda.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
public interface AgendaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AgendaResponse agendaCompromisso(@RequestBody AgendaRequest agendaRequest);
}
