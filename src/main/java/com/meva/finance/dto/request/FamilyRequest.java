package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;

import java.io.Serializable;

public class FamilyRequest implements Serializable {

    private Integer id;

//    @Size(max = 255, message = "Max de 255 caracteres")
//    @NotBlank(message = "Campo requirido")
    private String descricao;

    public FamilyRequest() {
    }

    public FamilyRequest(Family family){
        this.id = family.getId();
        this.descricao = family.getDescricao();
    }

    public Family convert(Family family) {
//        Family family = new Family();

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
