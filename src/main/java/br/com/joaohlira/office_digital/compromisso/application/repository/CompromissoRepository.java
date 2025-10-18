package br.com.joaohlira.office_digital.compromisso.application.repository;

import br.com.joaohlira.office_digital.compromisso.domain.Compromisso;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CompromissoRepository {
    Compromisso salva(Compromisso compromisso);

    List<Compromisso> buscaTodosOsCompromissos(LocalDate data);

    Compromisso buscaCompromissoPorId(UUID idCompromisso);
}
