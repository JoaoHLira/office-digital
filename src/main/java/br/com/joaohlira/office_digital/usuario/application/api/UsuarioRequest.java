package br.com.joaohlira.office_digital.usuario.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank String nome,
        @NotBlank String whastapp,
        @Email String email) {
}
