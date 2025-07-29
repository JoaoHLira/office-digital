package br.com.joaohlira.office_digital.usuario.application.api;

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

}
