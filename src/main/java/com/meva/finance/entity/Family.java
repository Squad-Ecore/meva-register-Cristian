package com.meva.finance.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "family")
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "family")
    private List<Usuario> usuarios;


    public Family() {
    }

    public Family(String descricao, List<Usuario> usuarios) {
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public Family(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(id, family.id) && Objects.equals(descricao, family.descricao) && Objects.equals(usuarios, family.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, usuarios);
    }
}
