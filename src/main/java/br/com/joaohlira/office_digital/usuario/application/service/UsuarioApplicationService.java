package br.com.joaohlira.office_digital.usuario.application.service;

import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import br.com.joaohlira.office_digital.usuario.application.api.UsuarioResponse;
import br.com.joaohlira.office_digital.usuario.application.repository.UsuarioRepository;
import br.com.joaohlira.office_digital.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse criaNovoUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioApplicationService - criaNovoUsuario");
        Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest));
        log.debug("[finish] UsuarioApplicationService - criaNovoUsuario");
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse buscaUsuario(UUID id) {
        log.info("[start] UsuarioApplicationService - buscaUsuario");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(id);
        log.debug("[finish] UsuarioApplicationService - buscaUsuario");
        return new UsuarioResponse(usuario);
    }
}
