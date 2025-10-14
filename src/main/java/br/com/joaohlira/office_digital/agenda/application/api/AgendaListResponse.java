package br.com.joaohlira.office_digital.agenda.application.api;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import br.com.joaohlira.office_digital.agenda.domain.TipoCompromisso;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class AgendaListResponse {
    private UUID id;
    private LocalDate data;
    private LocalTime horario;
    private TipoCompromisso tipoCompromisso;
    private String descricaoCompromisso;
    private String numeroProcesso;
    private LocalDateTime dataHoraCriacao;
    private Advogado advogadoResponsavel;

    public AgendaListResponse(Agenda agenda) {
        this.id = agenda.getId();
        this.data = agenda.getData();
        this.horario = agenda.getHorario();
        this.tipoCompromisso = agenda.getTipoCompromisso();
        this.descricaoCompromisso = agenda.getDescricaoCompromisso();
        this.numeroProcesso = agenda.getNumeroProcesso();
        this.dataHoraCriacao = agenda.getDataHoraCriacao();
        this.advogadoResponsavel = agenda.getAdvogadoResponsavel();
    }

    public static List<AgendaListResponse> converte(List<Agenda> compromissos) {
        return compromissos.stream()
                .map(AgendaListResponse::new)
                .collect(Collectors.toList());
    }
}
