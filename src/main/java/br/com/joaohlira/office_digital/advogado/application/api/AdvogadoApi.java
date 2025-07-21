package br.com.joaohlira.office_digital.advogado.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advogado/v1")
public interface AdvogadoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AdvogadoResponse criaNovoAdvogado(@RequestBody @Valid AdvogadoNovoRequest advogadoNovoRequest);
}
