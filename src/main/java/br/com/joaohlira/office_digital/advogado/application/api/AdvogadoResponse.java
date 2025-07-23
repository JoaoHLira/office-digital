package br.com.joaohlira.office_digital.advogado.application.api;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AdvogadoResponse {

    private UUID id;
    private String nome;
    private String numeroOab;
    private String estadoOab;
    private String whatsapp;
    private String email;

    public AdvogadoResponse(Advogado advogado) {
        this.id = advogado.getId();
        this.nome = advogado.getNome();
        this.numeroOab = advogado.getNumeroOab();
        this.estadoOab = advogado.getEstadoOab();
        this.whatsapp = advogado.getWhatsapp();
        this.email = advogado.getEmail();
    }
}
