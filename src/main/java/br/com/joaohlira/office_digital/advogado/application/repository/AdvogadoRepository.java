package br.com.joaohlira.office_digital.advogado.application.repository;

import br.com.joaohlira.office_digital.advogado.domain.Advogado;

public interface AdvogadoRepository {
    Advogado salva(Advogado advogado);
}
