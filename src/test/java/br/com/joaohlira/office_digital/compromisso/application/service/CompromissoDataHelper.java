package br.com.joaohlira.office_digital.compromisso.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoAltecacaoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoRequest;
import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import br.com.joaohlira.office_digital.compromisso.domain.TipoCompromisso;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class CompromissoDataHelper {

    private static final UUID ID_ADVOGADO = UUID.fromString("2f9b8a3e-3a39-4f3c-8e1f-9d5a3c2e1b5d");

    public static CompromissoRequest criaCompromissoRequest() {
        return new CompromissoRequest(
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 30),
                TipoCompromisso.AUDIENCIA,
                "Audiência de conciliação",
                "1234567-89.2023.8.05.0001",
                ID_ADVOGADO
        );
    }

    public static CompromissoAltecacaoRequest criaCompromissoAlteracaoRequest() {
        return new CompromissoAltecacaoRequest(
                LocalDate.now().plusDays(2),
                LocalTime.of(10, 0),
                TipoCompromisso.ATENDIMENTO,
                "Atendimento com cliente",
                "9876543-21.2023.8.05.0002"
        );
    }

    public static Compromisso criaCompromisso(Advogado advogado) {
        return new Compromisso(criaCompromissoRequest(), advogado);
    }

    public static Advogado criaAdvogado() {
        AdvogadoNovoRequest request = new AdvogadoNovoRequest("João Lira", "123456", "BA", "11999999999", "adv@email.com");
        return new Advogado(request);
    }
}