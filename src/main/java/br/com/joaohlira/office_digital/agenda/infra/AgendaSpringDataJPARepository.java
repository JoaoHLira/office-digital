package br.com.joaohlira.office_digital.agenda.infra;

import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, UUID> {
    List<Agenda> findAllByData(LocalDate data);
}
