package br.com.joaohlira.office_digital.compromisso.application.api;

import br.com.joaohlira.office_digital.compromisso.domain.TipoCompromisso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record CompromissoRequest(LocalDate data,
                            LocalTime horario,
                            TipoCompromisso tipoCompromisso,
                            String descricaoCompromisso,
                            String numeroProcesso,
                            LocalDateTime dataHoraCriacao,
                            UUID idAdvogadoResponsavel) {
}
