package br.com.joaohlira.office_digital.advogado.infra;

import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class AdvogadoInfraRepository implements AdvogadoRepository {

    private final AdvogadoSpringDataJPARepository advogadoSpringDataJPARepository;

    @Override
    public Advogado salva(Advogado advogado) {
        log.info("[start] AdvogadoInfraRepository - salva");
        Advogado advogadoCriado = advogadoSpringDataJPARepository.save(advogado);
        log.debug("[finish] AdvogadoInfraRepository - salva");
        return advogadoCriado;
    }
}
