package br.com.joaohlira.office_digital.advogado.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;

public class AdvogadoDataHelper {

    public static Advogado createAdvogado() {
        return new Advogado(createAdvogadoRequest());
    }

    public static AdvogadoNovoRequest createAdvogadoRequest() {
        return new AdvogadoNovoRequest("João", "123456", "BA", "11999999999", "adv@email.com");
    }
}
