package br.com.joaohlira.office_digital.advogado.infra;

import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class AdvogadoInfraRepository implements AdvogadoRepository {

    private final AdvogadoSpringDataJPARepository advogadoSpringDataJPARepository;

    @Override
    public Advogado salva(Advogado advogado) {
        log.info("[start] AdvogadoInfraRepository - salva");
        try {
            advogadoSpringDataJPARepository.save(advogado);
        } catch (DataIntegrityViolationException ex) {
            throw APIException.build(HttpStatus.CONFLICT, "Error: Email já cadastrado");
        }
        log.debug("[finish] AdvogadoInfraRepository - salva");
        return advogado;
    }

    @Override
    public Advogado buscaAdvogadoPorId(UUID id) {
        log.info("[start] AdvogadoInfraRepository - buscaAdvogadoPorId");
        Advogado advogado = advogadoSpringDataJPARepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Advogado não encontrado!"));
        log.debug("[finish] AdvogadoInfraRepository - buscaAdvogadoPorId");
        return advogado;
    }
}
