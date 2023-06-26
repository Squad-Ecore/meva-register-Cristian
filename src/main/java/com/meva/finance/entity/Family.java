package com.meva.finance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "family")
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "family")
    private List<Usuario> usuarios;


    public Family() {
    }

    public Family(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
