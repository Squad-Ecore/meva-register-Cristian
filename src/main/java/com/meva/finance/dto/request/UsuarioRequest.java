package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import com.meva.finance.entity.Usuario;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioRequest implements Serializable {

    private String cpf;

    @NotBlank(message = "nome e sobrenome")
    @Size(min = 4, max = 100)
    private String name;

    //    @Pattern(regexp = "[MF]")
    private char genre;

    @Past(message = "Apenas data de nascimento")
    private LocalDate birth;

    @NotBlank(message = "Apenas o nome do estado")
    @Size(max = 100)
    private String state;

    @NotEmpty(message = "Apenas o nome da cidade")
    @Size(max = 100)
    private String city;

    @Valid
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

    public FamilyRequest getFamilyRequest() {
        return familyRequest;
    }

    public void setFamilyRequest(FamilyRequest familyRequest) {
        this.familyRequest = familyRequest;
    }
}
