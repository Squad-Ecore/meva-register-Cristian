package com.meva.finance.api;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.dto.request.UsuarioRequest;
import com.meva.finance.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class userControllerTest {

    @Mock
    private UsuarioService usuarioService;
    @Mock
    private FamilyRequest familyRequest;
    @Mock
    private UsuarioRequest usuarioRequest;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {

    }

    @Test
    void update() {
    }
}