package br.com.joaohlira.office_digital.advogado.domain;

import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Getter
@Table(name = "advogado")
public class Advogado {


    private UUID id;
    private String nome;
    private String numeroOab;
    private String estadoOab;
    private String whatsapp;
    private String email;

}
