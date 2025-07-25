package br.com.joaohlira.office_digital.advogado.infra;

import br.com.joaohlira.office_digital.advogado.application.service.AdvogadoDataHelper;
import br.com.joaohlira.office_digital.advogado.domain.Advogado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(AdvogadoInfraRepository.class)
class AdvogadoInfraRepositoryTest {


    @Autowired
    private AdvogadoSpringDataJPARepository jpaRepository;

    @Autowired
    private AdvogadoInfraRepository infraRepository;

    @Test
    @DisplayName("Deve salvar um novo advogado e retornar com ID gerado")
    void salva_ComDadosValidos_DeveRetornarAdvogadoComId() {
        Advogado novo = AdvogadoDataHelper.createAdvogado();

        Advogado salvo = infraRepository.salva(novo);

        assertNotNull(salvo);
        assertNotNull(salvo.getId(), "ID deve ser gerado pelo banco");
        assertEquals(novo.getNome(), salvo.getNome());
    }
}