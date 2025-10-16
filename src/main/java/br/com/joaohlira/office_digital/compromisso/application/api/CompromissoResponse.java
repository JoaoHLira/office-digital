package br.com.joaohlira.office_digital.compromisso.application.api;

import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import br.com.joaohlira.office_digital.compromisso.domain.TipoCompromisso;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record CompromissoResponse(
        UUID id,
        LocalDate data,
        LocalTime horario,
        TipoCompromisso tipoCompromisso,
        String descricaoCompromisso,
        String numeroProcesso,
        UUID idAdvogadoResponsavel
) {
    public CompromissoResponse(Compromisso compromisso) {
        this(compromisso.getId(),
                compromisso.getData(),
                compromisso.getHorario(),
                compromisso.getTipoCompromisso(),
                compromisso.getDescricaoCompromisso(),
                compromisso.getNumeroProcesso(),
                compromisso.getAdvogadoResponsavel().getId());
    }
}
