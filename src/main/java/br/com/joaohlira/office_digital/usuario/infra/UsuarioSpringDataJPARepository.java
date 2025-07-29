package br.com.joaohlira.office_digital.usuario.infra;

import br.com.joaohlira.office_digital.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioSpringDataJPARepository extends JpaRepository<Usuario, UUID> {
}
