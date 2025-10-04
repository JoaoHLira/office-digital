package br.com.joaohlira.office_digital.agenda.infra;

import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendaSpringDataJPARepository extends JpaRepository<Agenda, UUID> {
}
