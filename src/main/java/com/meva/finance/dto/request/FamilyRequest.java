package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
public class FamilyRequest implements Serializable {

    @Positive
    @NotNull(message = "apenas numeros inteiros")
    private Integer id;

    @NotBlank(message = "descricao requirida")
    @Size(max = 100)
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
