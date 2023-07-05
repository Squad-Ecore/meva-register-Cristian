package com.meva.finance.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "family")
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family_id_seq")
    @SequenceGenerator(name = "family_id_seq", sequenceName = "family_id_seq", allocationSize = 1)
    private Long id;

    private String descricao;

    @OneToMany(mappedBy = "family")
    private List<Usuario> usuarios;


}
