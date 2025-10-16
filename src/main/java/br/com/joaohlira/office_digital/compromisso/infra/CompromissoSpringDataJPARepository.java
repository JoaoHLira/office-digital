package br.com.joaohlira.office_digital.compromisso.infra;

import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CompromissoSpringDataJPARepository extends JpaRepository<Compromisso, UUID> {
    List<Compromisso> findAllByData(LocalDate data);
}
