package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRequest {

    private Integer id;
    private String descricao;


    public Family convert(Family family) {
        family.setId(this.id);
        family.setDescricao(this.descricao);

        return family;
    }
}
