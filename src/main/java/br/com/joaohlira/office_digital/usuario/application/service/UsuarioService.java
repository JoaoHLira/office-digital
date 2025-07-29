package br.com.joaohlira.office_digital.usuario.application.service;

import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import br.com.joaohlira.office_digital.usuario.application.api.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse criaNovoUsuario(UsuarioRequest usuarioRequest);
}
