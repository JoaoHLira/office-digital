package br.com.joaohlira.office_digital.advogado.domain;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "advogado")
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String numeroOab;
    private String estadoOab;
    private String whatsapp;
    private String email;

    public Advogado(AdvogadoNovoRequest request) {
        this.nome = request.getNome();
        this.numeroOab = request.getNumeroOab();
        this.estadoOab = request.getEstadoOab();
        this.whatsapp = request.getWhatsapp();
        this.email = request.getEmail();
    }
}
