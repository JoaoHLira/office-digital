package br.com.joaohlira.office_digital.usuario.application.service;

import br.com.joaohlira.office_digital.handler.APIException;
import br.com.joaohlira.office_digital.usuario.application.api.UsuarioRequest;
import br.com.joaohlira.office_digital.usuario.application.api.UsuarioResponse;
import br.com.joaohlira.office_digital.usuario.application.repository.UsuarioRepository;
import br.com.joaohlira.office_digital.usuario.domain.Usuario;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioApplicationServiceTest {

    @InjectMocks
    UsuarioApplicationService usuarioApplicationService;

    @Mock
    UsuarioRepository usuarioRepository;


    @Test
    void deveCriarNovoUsuario() {
        UsuarioRequest request = UsuarioDataHelper.criaUsuarioRequest();
        Usuario usuario = UsuarioDataHelper.criaUsuario();
        when(usuarioRepository.salva(any(Usuario.class))).thenReturn(usuario);

        UsuarioResponse usuarioCriado = usuarioApplicationService.criaNovoUsuario(request);

        assertEquals(usuario.getEmail(), usuarioCriado.getEmail());
        verify(usuarioRepository, times(1)).salva(any(Usuario.class));
    }

    @Test
    void deveBuscarUsuarioPeloId() {
        Usuario usuario = UsuarioDataHelper.criaUsuario();
        when(usuarioRepository.buscaUsuarioPorId(any())).thenReturn(usuario);

        UsuarioResponse usuarioBuscado = usuarioApplicationService.buscaUsuario(any());

        assertEquals(usuario.getEmail(), usuarioBuscado.getEmail());
        verify(usuarioRepository, times(1)).buscaUsuarioPorId(any());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoEncontrado() {
        UUID idUsuarioInexistente = UUID.randomUUID();
        when(usuarioRepository.buscaUsuarioPorId(idUsuarioInexistente))
                .thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        APIException exception = assertThrows(APIException.class,
                () -> usuarioApplicationService.buscaUsuario(idUsuarioInexistente));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusException());
        assertEquals("Usuário não encontrado!", exception.getMessage());
    }
}