package br.com.joaohlira.office_digital.usuario.application.repository;

import br.com.joaohlira.office_digital.usuario.domain.Usuario;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);
}
