package com.meva.finance.dto.response;

import com.meva.finance.dto.request.FamilyRequest;
import com.meva.finance.entity.Usuario;

import java.time.LocalDate;

public class UsuarioResponse {

    //    private String cpf;
    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;
//    private FamilyRequest familyRequest;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Usuario usuario) {
        this.name = usuario.getName();
        this.genre = usuario.getGenre();
        this.birth = usuario.getBirth();
        this.state = usuario.getState();
        this.city = usuario.getCity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
