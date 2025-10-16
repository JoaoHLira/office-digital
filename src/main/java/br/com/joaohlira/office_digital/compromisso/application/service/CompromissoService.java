package br.com.joaohlira.office_digital.compromisso.application.service;

import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoListResponse;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoResponse;

import java.time.LocalDate;
import java.util.List;

public interface CompromissoService {
    CompromissoResponse criaNovoCompromisso(CompromissoRequest compromissoRequest);

    List<CompromissoListResponse> buscaCompromissos(LocalDate data);
}
