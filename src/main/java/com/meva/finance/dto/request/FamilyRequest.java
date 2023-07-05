package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import com.meva.finance.repository.FamilyRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
