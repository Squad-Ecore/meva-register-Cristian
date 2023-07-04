package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    private String cpf;
    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;
    private FamilyRequest familyRequest;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String cpf, String name, char genre, LocalDate birth, String state, String city, FamilyRequest familyRequest) {
        this.cpf = cpf;
        this.name = name;
        this.genre = genre;
        this.birth = birth;
        this.state = state;
        this.city = city;
        this.familyRequest = familyRequest;
    }

    public Usuario convert(Usuario usuario) {
//        Usuario usuario = new Usuario();

        usuario.setCpf(cpf);
        usuario.setName(name);
        usuario.setGenre(genre);
        usuario.setBirth(birth);
        usuario.setState(state);
        usuario.setCity(city);

        return usuario;
    }
}
