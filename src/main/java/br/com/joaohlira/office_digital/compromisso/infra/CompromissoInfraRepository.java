package br.com.joaohlira.office_digital.compromisso.infra;

import br.com.joaohlira.office_digital.compromisso.application.repository.CompromissoRepository;
import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import br.com.joaohlira.office_digital.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class CompromissoInfraRepository implements CompromissoRepository {

    private final CompromissoSpringDataJPARepository compromissoSpringDataJPARepository;

    @Override
    public Compromisso salva(Compromisso compromisso) {
        log.info("[start] CompromissoInfraRepository - salva");
        compromissoSpringDataJPARepository.save(compromisso);
        log.debug("[finish] CompromissoInfraRepository - salva");
        return compromisso;
    }

    @Override
    public List<Compromisso> buscaTodosOsCompromissos(LocalDate data) {
        log.info("[start] CompromissoInfraRepository - buscaTodosOsCompromissos");
        List<Compromisso> compromissos = compromissoSpringDataJPARepository.findAllByData(data);
        log.debug("[finish] CompromissoInfraRepository - buscaTodosOsCompromissos");
        return compromissos;
    }

    @Override
    public Compromisso buscaCompromissoPorId(UUID idCompromisso) {
        log.info("[start] CompromissoInfraRepository - buscaCompromissoPorId");
        Compromisso compromisso = compromissoSpringDataJPARepository.findById(idCompromisso)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Compromisso não encontrado!"));
        log.debug("[finish] CompromissoInfraRepository - buscaCompromissoPorId");
        return compromisso;
    }
}
