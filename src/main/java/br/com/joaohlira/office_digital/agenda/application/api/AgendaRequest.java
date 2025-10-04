package br.com.joaohlira.office_digital.agenda.application.api;

import br.com.joaohlira.office_digital.agenda.domain.TipoCompromisso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record AgendaRequest(LocalDate data,
                            LocalTime horario,
                            TipoCompromisso tipoCompromisso,
                            String descricaoCompromisso,
                            String numeroProcesso,
                            LocalDateTime dataHoraCriacao,
                            UUID idAdvogadoResponsavel) {
}
