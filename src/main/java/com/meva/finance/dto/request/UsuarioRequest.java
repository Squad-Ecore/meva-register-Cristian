package com.meva.finance.dto.request;

import com.meva.finance.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    private String cpf;
    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;
    private FamilyRequest familyRequest;


    public Usuario convert(Usuario usuario) {

        usuario.setCpf(cpf);
        usuario.setName(name);
        usuario.setGenre(genre);
        usuario.setBirth(birth);
        usuario.setState(state);
        usuario.setCity(city);

        return usuario;
    }
}
