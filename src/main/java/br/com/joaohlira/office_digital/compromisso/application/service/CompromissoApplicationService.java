package br.com.joaohlira.office_digital.compromisso.application.service;

import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoAltecacaoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoListResponse;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoRequest;
import br.com.joaohlira.office_digital.compromisso.application.api.CompromissoResponse;
import br.com.joaohlira.office_digital.compromisso.application.repository.CompromissoRepository;
import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class CompromissoApplicationService implements CompromissoService {

    private final CompromissoRepository compromissoRepository;
    private final AdvogadoRepository advogadoRepository;

    @Override
    public CompromissoResponse criaNovoCompromisso(CompromissoRequest compromissoRequest) {
        log.info("[start] CompromissoApplicationService - criaNovoCompromisso");
        Advogado advogado = advogadoRepository.buscaAdvogadoPorId(compromissoRequest.idAdvogadoResponsavel());
        Compromisso compromissoAgendado = compromissoRepository.salva(new Compromisso(compromissoRequest, advogado));
        log.debug("[finish] CompromissoApplicationService - criaNovoCompromisso");
        return new CompromissoResponse(compromissoAgendado);
    }

    @Override
    public List<CompromissoListResponse> buscaCompromissos(LocalDate data) {
        log.info("[start] CompromissoApplicationService - buscaCompromissos");
        LocalDate dataBusca = (data != null) ? data : LocalDate.now();
        List<Compromisso> compromissos = compromissoRepository.buscaTodosOsCompromissos(dataBusca);
        log.debug("[finish] CompromissoApplicationService - buscaCompromissos");
        return CompromissoListResponse.converte(compromissos);
    }

    @Override
    public void atualizaCompromisso(UUID idCompromisso, CompromissoAltecacaoRequest alteracaoRequest) {
        log.info("[start] CompromissoApplicationService - atualizaCompromisso");
        Compromisso compromisso = compromissoRepository.buscaCompromissoPorId(idCompromisso);
        compromisso.atualiza(alteracaoRequest);
        compromissoRepository.salva(compromisso);
        log.debug("[finish] CompromissoApplicationService - atualizaCompromisso");
    }
}
