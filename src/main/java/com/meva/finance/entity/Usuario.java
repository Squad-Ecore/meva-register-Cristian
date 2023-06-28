package com.meva.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "user_meva")
public class Usuario {

    @Id
    @Column(unique = true)
    @Size(max = 11)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)

    private char genre;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Column(nullable = false)
    @Size(max = 100)
    private String state;

    @Column(nullable = false)
    @Size(max = 100)
    private String city;

    @ManyToOne
    @JoinColumn(name = "id_family", nullable = false)
    private Family family;


    public Usuario() {
    }

    public Usuario(String cpf, String name, char genre, LocalDate birth, String state, String city, Family family) {
        this.cpf = cpf;
        this.name = name;
        this.genre = genre;
        this.birth = birth;
        this.state = state;
        this.city = city;
        this.family = family;
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return genre == usuario.genre && Objects.equals(cpf, usuario.cpf) && Objects.equals(name, usuario.name) && Objects.equals(birth, usuario.birth) && Objects.equals(state, usuario.state) && Objects.equals(city, usuario.city) && Objects.equals(family, usuario.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, genre, birth, state, city, family);
    }
}
