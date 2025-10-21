package br.com.joaohlira.office_digital.compromisso.application.service;

import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoAltecacaoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoListResponse;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoResponse;
import br.com.joaohlira.office_digital.compromisso.application.repository.CompromissoRepository;
import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompromissoApplicationServiceTest {

    @InjectMocks
    private CompromissoApplicationService compromissoApplicationService;

    @Mock
    private CompromissoRepository compromissoRepository;
    @Mock
    private AdvogadoRepository advogadoRepository;

    @Test
    void deveCriarNovoCompromisso() {
        CompromissoRequest request = CompromissoDataHelper.criaCompromissoRequest();
        Advogado advogado = CompromissoDataHelper.criaAdvogado();
        Compromisso compromisso = CompromissoDataHelper.criaCompromisso(advogado);

        when(advogadoRepository.buscaAdvogadoPorId(request.idAdvogadoResponsavel())).thenReturn(advogado);
        when(compromissoRepository.salva(any(Compromisso.class))).thenReturn(compromisso);

        CompromissoResponse response = compromissoApplicationService.criaNovoCompromisso(request);

        assertEquals(compromisso.getId(), response.id());
        verify(advogadoRepository, times(1)).buscaAdvogadoPorId(request.idAdvogadoResponsavel());
        verify(compromissoRepository, times(1)).salva(any(Compromisso.class));
    }

    @Test
    void deveBuscarCompromissosPorData() {
        LocalDate dataBusca = LocalDate.of(2025, 1, 10);
        List<Compromisso> compromissos = List.of(CompromissoDataHelper.criaCompromisso(CompromissoDataHelper.criaAdvogado()));
        when(compromissoRepository.buscaTodosOsCompromissos(dataBusca)).thenReturn(compromissos);

        List<CompromissoListResponse> response = compromissoApplicationService.buscaCompromissos(dataBusca);

        assertEquals(1, response.size());
        verify(compromissoRepository, times(1)).buscaTodosOsCompromissos(dataBusca);
    }

    @Test
    void deveAtualizarCompromisso() {
        UUID idCompromisso = UUID.randomUUID();
        CompromissoAltecacaoRequest request = CompromissoDataHelper.criaCompromissoAlteracaoRequest();
        Compromisso compromisso = mock(Compromisso.class);

        when(compromissoRepository.buscaCompromissoPorId(idCompromisso)).thenReturn(compromisso);

        compromissoApplicationService.atualizaCompromisso(idCompromisso, request);

        verify(compromissoRepository, times(1)).buscaCompromissoPorId(idCompromisso);
        verify(compromisso, times(1)).atualiza(request);
        verify(compromissoRepository, times(1)).salva(compromisso);
    }

    @Test
    void deveCancelarCompromissoAgendado() {
        UUID idCompromisso = UUID.randomUUID();
        Compromisso compromisso = mock(Compromisso.class);
        when(compromissoRepository.buscaCompromissoPorId(idCompromisso)).thenReturn(compromisso);

        compromissoApplicationService.cancelaCompromissoAgendado(idCompromisso);

        verify(compromissoRepository, times(1)).buscaCompromissoPorId(idCompromisso);
        verify(compromisso, times(1)).cancela();
        verify(compromissoRepository, times(1)).salva(compromisso);
    }
}