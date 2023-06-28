package com.meva.finance.dto;

import com.meva.finance.entity.Family;

public class FamilyDto {

    private Integer id;
    private String descricao;

    public FamilyDto() {
    }

    public FamilyDto(Family family){
        this.id = family.getId();
        this.descricao = family.getDescricao();
    }

    public Family convert() {
        Family family = new Family();
        family.setId(this.id);
        family.setDescricao(this.descricao);

        return family;
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
