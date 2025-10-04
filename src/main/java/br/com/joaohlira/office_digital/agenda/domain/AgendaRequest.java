package br.com.joaohlira.office_digital.agenda.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AgendaRequest(LocalDate data,
                            LocalTime horario,
                            TipoCompromisso tipoCompromisso,
                            String descricaoCompromisso,
                            String numeroProcesso,
                            LocalDateTime dataHoraCriacao) {
}
