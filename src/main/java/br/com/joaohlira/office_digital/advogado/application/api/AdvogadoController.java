package br.com.joaohlira.office_digital.advogado.application.api;

import br.com.joaohlira.office_digital.advogado.application.service.AdvogadoService;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class AdvogadoController implements AdvogadoApi {

    private final AdvogadoService advogadoService;

    @Override
    public AdvogadoResponse criaNovoAdvogado(AdvogadoNovoRequest advogadoNovoRequest) {
        log.info("[start] AdvogadoController - criaNovoAdvogado");
        AdvogadoResponse advogadoCriado = advogadoService.criaAdvogado(advogadoNovoRequest);
        log.debug("[finish] AdvogadoController - criaNovoAdvogado");
        return advogadoCriado;
    }

    @Override
    public AdvogadoResponse buscaAdvogadoPorId(UUID id) {
        log.info("[start] AdvogadoController - buscaAdvogadoPorId");
        AdvogadoResponse response = advogadoService.buscaAdvogadoPorId(id);
        log.debug("[finish] AdvogadoController - buscaAdvogadoPorId");
        return response;
    }
}
