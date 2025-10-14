package br.com.joaohlira.office_digital.agenda.application.repository;

import br.com.joaohlira.office_digital.agenda.domain.Agenda;

import java.util.List;

public interface AgendaRepository {
    Agenda salva(Agenda agenda);

    List<Agenda> buscaTodosOsCompromissos();
}
