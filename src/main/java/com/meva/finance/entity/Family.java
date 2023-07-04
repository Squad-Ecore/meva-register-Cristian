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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//, generator = "family_sequence")
    private Long id;
//    @SequenceGenerator(name = "family_sequence", sequenceName = "family_sequence", allocationSize = 1)

    private String descricao;

    @OneToMany(mappedBy = "family")
    private List<Usuario> usuarios;


}
