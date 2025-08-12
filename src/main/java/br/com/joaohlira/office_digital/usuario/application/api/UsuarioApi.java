package br.com.joaohlira.office_digital.usuario.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/usuario/v1")
public interface UsuarioApi {

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    UsuarioResponse cadastraUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest);

    @GetMapping("/busca/{id}")
    @ResponseStatus(HttpStatus.OK)
    UsuarioResponse buscaUsuario(@PathVariable UUID id);
}
