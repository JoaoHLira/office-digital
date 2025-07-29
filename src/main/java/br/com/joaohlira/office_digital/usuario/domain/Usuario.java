package br.com.joaohlira.office_digital.usuario.domain;

import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "usuario", schema = "office-digital")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String whatsapp;
    private String email;
    private LocalDateTime dataHoraCadastro;

    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.nome();
        this.whatsapp = usuarioRequest.whastapp();
        this.email = usuarioRequest.email();
        this.dataHoraCadastro = LocalDateTime.now();
    }
}
