package br.com.joaohlira.office_digital.advogado.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoAlteracaoRequest;
import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;

import java.util.UUID;

public class AdvogadoDataHelper {

    public static Advogado createAdvogado() {
        return new Advogado(createAdvogadoRequest());
    }

    public static AdvogadoNovoRequest createAdvogadoRequest() {
        return new AdvogadoNovoRequest("João", "123456", "BA", "11999999999", "adv@email.com");
    }

    public static AdvogadoAlteracaoRequest createAlteracaoRequest() {
        return new AdvogadoAlteracaoRequest(UUID.fromString("bf105f43-7fc7-4ec9-a6cb-ca77ee71aa82"),
                "Joao Lira",
                "123456",
                "BA",
                "11999999999",
                "novo-email@email.com");
    }
}
