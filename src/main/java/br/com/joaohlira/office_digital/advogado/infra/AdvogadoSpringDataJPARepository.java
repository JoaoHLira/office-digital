package br.com.joaohlira.office_digital.advogado.infra;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdvogadoSpringDataJPARepository extends JpaRepository<Advogado, UUID> {
}
