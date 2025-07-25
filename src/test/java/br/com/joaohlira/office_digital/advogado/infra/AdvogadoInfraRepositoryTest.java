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

import java.util.UUID;

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
    void deveSalvarAdvogadoEGerarId() {
        Advogado novoAdvogado = AdvogadoDataHelper.createAdvogado();

        Advogado advogadoNovoCriado = infraRepository.salva(novoAdvogado);

        assertNotNull(advogadoNovoCriado);
        assertNotNull(advogadoNovoCriado.getId(), "ID deve ser gerado pelo banco");
        assertEquals(novoAdvogado.getNome(), advogadoNovoCriado.getNome());
    }

    @Test
    @DisplayName("Deve buscar Advogado pelo ID")
    void deveBuscarAdvogadoPeloId() {
        Advogado advogado = infraRepository.buscaAdvogadoPorId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));

        assertEquals(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), advogado.getId());
        assertEquals("Daniel Farias", advogado.getNome());
    }
}