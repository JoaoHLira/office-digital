package br.com.joaohlira.office_digital.compromisso.application.api;

import br.com.joaohlira.office_digital.compromisso.domain.TipoCompromisso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompromissoAltecacaoRequest(@NotNull LocalDate data,
                                          @NotNull LocalTime horario,
                                          @NotNull TipoCompromisso tipoCompromisso,
                                          @NotBlank String descricaoCompromisso,
                                          String numeroProcesso) {
}
