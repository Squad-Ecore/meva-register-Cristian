package com.meva.finance.dto.request;

import com.meva.finance.entity.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class UsuarioRequestTest {

    @Mock
    private UsuarioRequest usuarioRequest;
    @Mock
    private Usuario usuario;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);

        usuarioRequest = new UsuarioRequest("12345678900", "Cristian", 'M',
                LocalDate.of(2004, 3, 8),
                "São Paulo", "São Paulo", new FamilyRequest(1, "Vieira"));

        Usuario usuario;
    }

    @Test
    @DisplayName("teste que verifica se o cpf do usuarioRequest é o mesmo que vai chegar na entity usuario")
    void convert() {
        usuario = usuarioRequest.convert(new Usuario());

        Assertions.assertEquals(usuario.getCpf(), usuarioRequest.getCpf());
    }
}