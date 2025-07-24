package br.com.joaohlira.office_digital.advogado.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AdvogadoAlteracaoRequest(
        @NotBlank UUID id,
        @NotBlank String nome,
        @NotBlank String numeroOab,
        @NotBlank String estadoOab,
        @NotBlank String whatsapp,
        @Email String email) {
}
