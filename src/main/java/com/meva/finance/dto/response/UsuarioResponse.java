package com.meva.finance.dto.response;

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
public class UsuarioResponse {

    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;

    public UsuarioResponse(Usuario usuario) {
        this.name = usuario.getName();
        this.genre = usuario.getGenre();
        this.birth = usuario.getBirth();
        this.state = usuario.getState();
        this.city = usuario.getCity();
    }

}
