package br.com.joaohlira.office_digital.agenda.application.service;

import br.com.joaohlira.office_digital.advogado.application.repository.AdvogadoRepository;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import br.com.joaohlira.office_digital.agenda.application.api.AgendaListResponse;
import br.com.joaohlira.office_digital.agenda.application.api.AgendaRequest;
import br.com.joaohlira.office_digital.agenda.application.api.AgendaResponse;
import br.com.joaohlira.office_digital.agenda.application.repository.AgendaRepository;
import br.com.joaohlira.office_digital.agenda.domain.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class AgendaApplicationService implements AgendaService {

    private final AgendaRepository agendaRepository;

    private final AdvogadoRepository advogadoRepository;

    @Override
    public AgendaResponse criaNovoCompromisso(AgendaRequest agendaRequest) {
        log.info("[start] AgendaApplicationService - criaNovoCompromisso");
        Advogado advogado = advogadoRepository.buscaAdvogadoPorId(agendaRequest.idAdvogadoResponsavel());
        Agenda compromissoAgendado = agendaRepository.salva(new Agenda(agendaRequest, advogado));
        log.debug("[finish] AgendaApplicationService - criaNovoCompromisso");
        return new AgendaResponse(compromissoAgendado);
    }

    @Override
    public List<AgendaListResponse> buscaCompromissos(LocalDate data) {
        log.info("[start] AgendaApplicationService - buscaCompromissos");
        LocalDate dataBusca = (data != null) ? data : LocalDate.now();
        List<Agenda> compromissos = agendaRepository.buscaTodosOsCompromissos(dataBusca);
        log.debug("[finish] AgendaApplicationService - buscaCompromissos");
        return AgendaListResponse.converte(compromissos);
    }
}
