package br.com.joaohlira.office_digital.compromisso.domain;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoAltecacaoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "compromisso", schema = "office-digital")
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate data;
    private LocalTime horario;
    @Enumerated(EnumType.STRING)
    private TipoCompromisso tipoCompromisso;
    @Enumerated(EnumType.STRING)
    private StatusCompromisso statusCompromisso;
    private String descricaoCompromisso;
    private String numeroProcesso;
    private LocalDateTime dataHoraCriacao;
    @ManyToOne
    @JoinColumn(name = "advogado_responsavel_id")
    private Advogado advogadoResponsavel;

    public Compromisso(CompromissoRequest compromissoRequest, Advogado advogado) {
        this.data = compromissoRequest.data();
        this.horario = compromissoRequest.horario();
        this.tipoCompromisso = compromissoRequest.tipoCompromisso();
        this.statusCompromisso = StatusCompromisso.AGENDADO;
        this.numeroProcesso = compromissoRequest.numeroProcesso();
        this.descricaoCompromisso = compromissoRequest.descricaoCompromisso();
        this.dataHoraCriacao = LocalDateTime.now();
        this.advogadoResponsavel = advogado;
    }

    public void atualiza(CompromissoAltecacaoRequest alteracaoRequest) {
        this.data = alteracaoRequest.data();
        this.horario = alteracaoRequest.horario();
        this.tipoCompromisso = alteracaoRequest.tipoCompromisso();
        this.numeroProcesso = alteracaoRequest.numeroProcesso();
        this.descricaoCompromisso = alteracaoRequest.descricaoCompromisso();
        this.dataHoraCriacao = LocalDateTime.now();
    }
}
