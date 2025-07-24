package br.com.joaohlira.office_digital.advogado.application.service;

import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoAlteracaoRequest;
import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoNovoRequest;
import br.com.joaohlira.office_digital.advogado.application.api.AdvogadoResponse;
import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.handler.APIException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdvogadoApplicationServiceTest {

    @InjectMocks
    AdvogadoApplicationService advogadoApplicationService;

    @Mock
    AdvogadoRepository advogadoRepository;

    @Test
    void deveCriarNovoAdvogado() {
        Advogado advogado = AdvogadoDataHelper.createAdvogado();
        AdvogadoNovoRequest request = AdvogadoDataHelper.createAdvogadoRequest();
        when(advogadoRepository.salva(any())).thenReturn(advogado);

        AdvogadoResponse advogadoCriado = advogadoApplicationService.criaAdvogado(request);

        assertEquals(advogado.getNome(), advogadoCriado.getNome());
        verify(advogadoRepository, times(1)).salva(any());
    }

    @Test
    void deveRetornarAdvogadoPeloId() {
        Advogado advogado = AdvogadoDataHelper.createAdvogado();
        when(advogadoRepository.buscaAdvogadoPorId(any())).thenReturn(advogado);

        AdvogadoResponse response = advogadoApplicationService.buscaAdvogadoPorId(any());

        assertEquals(advogado.getNome(), response.getNome());
        verify(advogadoRepository, times(1)).buscaAdvogadoPorId(any());
    }

    @Test
    void deveLancarExcecaoQuandoIdInvalido() {
        UUID idInexistente = UUID.randomUUID();
        when(advogadoRepository.buscaAdvogadoPorId(idInexistente))
                .thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Advogado não encontrado!"));

        APIException exception = assertThrows(APIException.class,
                () -> advogadoApplicationService.buscaAdvogadoPorId(idInexistente));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusException());
        assertEquals("Advogado não encontrado!", exception.getMessage());
        verify(advogadoRepository, times(1)).buscaAdvogadoPorId(any());
    }

    @Test
    void deveAlterarDadosDoAdvogado() {
        Advogado advogado = AdvogadoDataHelper.createAdvogado();
        AdvogadoAlteracaoRequest request = AdvogadoDataHelper.createAlteracaoRequest();
        when(advogadoRepository.buscaAdvogadoPorId(request.id())).thenReturn(advogado);
        when(advogadoRepository.salva(advogado)).thenReturn(advogado);

        advogadoApplicationService.alteraDadosDoAdvogado(request);

        verify(advogadoRepository, times(1)).buscaAdvogadoPorId(request.id());
        verify(advogadoRepository, times(1)).salva(advogado);
    }
}
