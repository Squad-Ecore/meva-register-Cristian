package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyRequest {

    private Long id;
    private String descricao;

    public FamilyRequest() {
    }

    public FamilyRequest(Family family) {
        this.id = family.getId();
        this.descricao = family.getDescricao();
    }

    public Family convert(Family family) {
        family.setId(this.id);
        family.setDescricao(this.descricao);

        return family;
    }
}
