package br.com.joaohlira.office_digital.usuario.application.api;

import br.com.joaohlira.office_digital.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuarioApi {

    private final UsuarioService usuarioService;

    @Override
    public UsuarioResponse cadastraUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioController - cadastraUsuario");
        UsuarioResponse usuarioCadastrado = usuarioService.criaNovoUsuario(usuarioRequest);
        log.debug("[finish] UsuarioController - cadastraUsuario");
        return usuarioCadastrado;
    }
}
