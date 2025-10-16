package br.com.joaohlira.office_digital.compromisso.application.repository;

import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;

import java.time.LocalDate;
import java.util.List;

public interface CompromissoRepository {
    Compromisso salva(Compromisso compromisso);

    List<Compromisso> buscaTodosOsCompromissos(LocalDate data);
}
