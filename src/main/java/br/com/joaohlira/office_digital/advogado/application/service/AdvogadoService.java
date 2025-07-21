package br.com.joaohlira.office_digital.advogado.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoResponse;

public interface AdvogadoService {

    AdvogadoResponse criaAdvogado(AdvogadoNovoRequest advogadoNovoRequest);
}
