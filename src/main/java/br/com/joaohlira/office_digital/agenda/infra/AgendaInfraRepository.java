package br.com.joaohlira.office_digital.agenda.infra;

import br.com.joaohlira.office_digital.agenda.application.repository.AgendaRepository;
import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Repository
@RequiredArgsConstructor
public class AgendaInfraRepository implements AgendaRepository {

    private final AgendaSpringDataJPARepository agendaSpringDataJPARepository;

    @Override
    public Agenda salva(Agenda agenda) {
        log.info("[start] AgendaInfraRepository - salva");
        agendaSpringDataJPARepository.save(agenda);
        log.debug("[finish] AgendaInfraRepository - salva");
        return agenda;
    }

    @Override
    public List<Agenda> buscaTodosOsCompromissos(LocalDate data) {
        log.info("[start] AgendaInfraRepository - buscaTodosOsCompromissos");
        List<Agenda> compromissos = agendaSpringDataJPARepository.findAllByData(data);
        log.debug("[finish] AgendaInfraRepository - buscaTodosOsCompromissos");
        return compromissos;
    }
}
