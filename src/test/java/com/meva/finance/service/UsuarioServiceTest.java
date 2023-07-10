package com.meva.finance.service;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private UsuarioRequest usuarioRequest;
    @Mock
    private FamilyRequest familyRequest;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        Usuario usuario;
    }


    @Test
    @DisplayName("save Usuario")
    void save() {
        familyRequest = new FamilyRequest(1, "Vieira");

        usuarioRequest = new UsuarioRequest("12345678900", "Cristian", 'M',
                LocalDate.of(2004, 3, 8),
                "São Paulo", "São Paulo", familyRequest);

        Usuario usuario = usuarioRequest.convert(new Usuario());


    }

    @Test
    void deleteId() {


    }

    @Test
    void update() {


    }

}