package br.com.joaohlira.office_digital.usuario.application.service;

import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import br.com.joaohlira.office_digital.usuario.domain.Usuario;

public class UsuarioDataHelper {

    public static Usuario criaUsuario() {
        return new Usuario(criaUsuarioRequest());
    }

    public static UsuarioRequest criaUsuarioRequest() {
        return new UsuarioRequest("Bianca", "73912345678", "bianca@gmail.com");
    }

}
