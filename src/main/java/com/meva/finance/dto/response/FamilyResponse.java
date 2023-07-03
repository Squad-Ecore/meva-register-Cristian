package com.meva.finance.dto.response;

import com.meva.finance.entity.Family;

public class FamilyResponse {

    private Long id;
    private String descricao;

    public FamilyResponse(){}

    public Family request(Family family){
        this.id = family.getId();
        this.descricao = family.getDescricao();

        return family;
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
}
