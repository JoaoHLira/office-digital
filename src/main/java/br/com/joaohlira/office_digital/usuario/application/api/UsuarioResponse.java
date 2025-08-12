package br.com.joaohlira.office_digital.usuario.application.api;

import br.com.joaohlira.office_digital.usuario.domain.Usuario;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class UsuarioResponse {

    private UUID id;
    private String nome;
    private String whatsapp;
    private String email;
    private LocalDateTime dataHoraCadastro;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.whatsapp = usuario.getWhatsapp();
        this.email = usuario.getEmail();
        this.dataHoraCadastro = usuario.getDataHoraCadastro();
    }
}
