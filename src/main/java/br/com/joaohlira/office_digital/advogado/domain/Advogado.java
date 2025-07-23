package br.com.joaohlira.office_digital.advogado.domain;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
        this.nome = request.nome();
        this.numeroOab = request.numeroOab();
        this.estadoOab = request.estadoOab();
        this.whatsapp = request.whatsapp();
        this.email = request.email();
    }
}
