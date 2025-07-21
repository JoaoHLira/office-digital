package br.com.joaohlira.office_digital.advogado.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AdvogadoNovoRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String numeroOab;
    @NotBlank
    private String estadoOab;
    @NotBlank
    private String whatsapp;
    @Email
    private String email;

}
