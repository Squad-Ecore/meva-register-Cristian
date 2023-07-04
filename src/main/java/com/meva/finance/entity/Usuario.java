package com.meva.finance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user_meva")
public class Usuario {

    @Id
    @Column(unique = true)
    @Size(max = 11)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)

    private char genre;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Column(nullable = false)
    @Size(max = 100)
    private String state;

    @Column(nullable = false)
    @Size(max = 100)
    private String city;

    @ManyToOne
    @JoinColumn(name = "id_family", nullable = false)
    private Family family;
}
