package br.com.joaohlira.office_digital.compromisso.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequestMapping("/compromisso")
public interface CompromissoAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompromissoResponse agendaCompromisso(@RequestBody CompromissoRequest compromissoRequest);

    @GetMapping("/busca-por-data")
    @ResponseStatus(HttpStatus.OK)
    List<CompromissoListResponse> buscaCompromissosPorData(@RequestParam(value = "data", required = false) LocalDate data);

    @PatchMapping("/atualiza/{idCompromisso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void atualizaCompromisso(@PathVariable UUID idCompromisso, @RequestBody CompromissoAltecacaoRequest alteracaoRequest);
}
