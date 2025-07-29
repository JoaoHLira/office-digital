package br.com.joaohlira.office_digital.usuario.infra;

import br.com.joaohlira.office_digital.handler.APIException;
import br.com.joaohlira.office_digital.usuario.application.repository.UsuarioRepository;
import br.com.joaohlira.office_digital.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {

    private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - salva");
        try {
            log.debug("[finish] UsuarioInfraRepository - salva");
            return usuarioSpringDataJPARepository.save(usuario);
        } catch (Exception e) {
            throw APIException.build(HttpStatus.CONFLICT, "Email já cadastrado");
        }
    }
}
