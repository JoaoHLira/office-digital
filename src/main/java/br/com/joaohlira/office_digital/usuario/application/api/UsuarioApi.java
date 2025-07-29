package br.com.joaohlira.office_digital.usuario.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/usuario/v1")
public interface UsuarioApi {

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    UsuarioResponse cadastraUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest);
}
