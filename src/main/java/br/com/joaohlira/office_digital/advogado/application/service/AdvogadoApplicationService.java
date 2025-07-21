package br.com.joaohlira.office_digital.advogado.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoResponse;
import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdvogadoApplicationService implements AdvogadoService {

    private final AdvogadoRepository advogadoRepository;

    @Override
    public AdvogadoResponse criaAdvogado(AdvogadoNovoRequest advogadoNovoRequest) {
        log.info("[start] AdvogadoApplicationService - criaAdvogado");
        Advogado advogadoCriado = advogadoRepository.salva(new Advogado(advogadoNovoRequest));
        log.debug("[finish] AdvogadoApplicationService - criaAdvogado");
        return new AdvogadoResponse(advogadoCriado);
    }
}
