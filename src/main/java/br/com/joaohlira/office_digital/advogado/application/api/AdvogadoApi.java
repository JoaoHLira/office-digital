package br.com.joaohlira.office_digital.advogado.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/advogado/v1")
public interface AdvogadoApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AdvogadoResponse criaNovoAdvogado(@RequestBody @Valid AdvogadoNovoRequest advogadoNovoRequest);

    @GetMapping("/busca-adv/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    AdvogadoResponse buscaAdvogadoPorId(@PathVariable UUID id);

    @PatchMapping("/altera-dados")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraDatosDoAdvogado(@RequestBody AdvogadoAlteracaoRequest advogadoAlteracaoRequest);
}
