package br.com.joaohlira.office_digital.usuario.application.service;

import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import br.com.joaohlira.office_digital.usuario.application.api.UsuarioResponse;

import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criaNovoUsuario(UsuarioRequest usuarioRequest);

    UsuarioResponse buscaUsuario(UUID id);
}
