package com.meva.finance.dto.response;

import com.meva.finance.entity.Family;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyResponse {

    private Integer id;
    private String descricao;

    public FamilyResponse() {
    }

    public Family request(Family family) {
        this.id = family.getId();
        this.descricao = family.getDescricao();

        return family;
    }

}
