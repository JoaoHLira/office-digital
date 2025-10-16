package br.com.joaohlira.office_digital.compromisso.application.api;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import br.com.joaohlira.office_digital.compromisso.domain.TipoCompromisso;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class CompromissoListResponse {
    private UUID id;
    private LocalDate data;
    private LocalTime horario;
    private TipoCompromisso tipoCompromisso;
    private String descricaoCompromisso;
    private String numeroProcesso;
    private LocalDateTime dataHoraCriacao;
    private Advogado advogadoResponsavel;

    public CompromissoListResponse(Compromisso compromisso) {
        this.id = compromisso.getId();
        this.data = compromisso.getData();
        this.horario = compromisso.getHorario();
        this.tipoCompromisso = compromisso.getTipoCompromisso();
        this.descricaoCompromisso = compromisso.getDescricaoCompromisso();
        this.numeroProcesso = compromisso.getNumeroProcesso();
        this.dataHoraCriacao = compromisso.getDataHoraCriacao();
        this.advogadoResponsavel = compromisso.getAdvogadoResponsavel();
    }

    public static List<CompromissoListResponse> converte(List<Compromisso> compromissos) {
        return compromissos.stream()
                .map(CompromissoListResponse::new)
                .collect(Collectors.toList());
    }
}
