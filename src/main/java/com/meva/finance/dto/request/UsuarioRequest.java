package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@ToString
public class UsuarioRequest implements Serializable {

    private String cpf;
    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;
    private FamilyRequest familyRequest;

    public UsuarioRequest() {
    }

    public Usuario convert(Usuario usuario) {
        usuario.setCpf(cpf);
        usuario.setName(name);
        usuario.setGenre(genre);
        usuario.setBirth(birth);
        usuario.setState(state);
        usuario.setCity(city);
        usuario.setFamily(familyRequest.convert(new Family()));

        return usuario;
    }
}
