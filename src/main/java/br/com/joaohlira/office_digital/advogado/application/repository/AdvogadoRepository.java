package br.com.joaohlira.office_digital.advogado.application.repository;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;

import java.util.UUID;

public interface AdvogadoRepository {
    Advogado salva(Advogado advogado);

    Advogado buscaAdvogadoPorId(UUID id);
}
