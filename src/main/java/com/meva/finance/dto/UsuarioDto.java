package com.meva.finance.dto;

import com.meva.finance.entity.Usuario;

import java.time.LocalDate;

public class UsuarioDto {


    private String cpf;
    private String name;
    private char genre;
    private LocalDate birth;
    private String state;
    private String city;
    private FamilyDto familyDto;

    public UsuarioDto() {
    }

    public Usuario convert() {
        Usuario usuario = new Usuario();

        usuario.setCpf(cpf);
        usuario.setName(name);
        usuario.setGenre(genre);
        usuario.setBirth(birth);
        usuario.setState(state);
        usuario.setCity(city);
        usuario.setFamily(familyDto.convert());

        return usuario;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public FamilyDto getFamilyDto() {
        return familyDto;
    }

    public void setFamilyDto(FamilyDto familyDto) {
        this.familyDto = familyDto;
    }
}
