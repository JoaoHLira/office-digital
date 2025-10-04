package br.com.joaohlira.office_digital.agenda.application.api;

import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import br.com.joaohlira.office_digital.agenda.domain.TipoCompromisso;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record AgendaResponse(
        UUID id,
        LocalDate data,
        LocalTime horario,
        TipoCompromisso tipoCompromisso,
        String descricaoCompromisso,
        String numeroProcesso,
        UUID idAdvogadoResponsavel
) {
    public AgendaResponse(Agenda agenda) {
        this(agenda.getId(),
                agenda.getData(),
                agenda.getHorario(),
                agenda.getTipoCompromisso(),
                agenda.getDescricaoCompromisso(),
                agenda.getNumeroProcesso(),
                agenda.getAdvogadoResponsavel().getId());
    }
}
