package br.com.joaohlira.office_digital.usuario.application.repository;

import br.com.joaohlira.office_digital.usuario.domain.Usuario;

import java.util.UUID;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);

    Usuario buscaUsuarioPorId(UUID id);
}
