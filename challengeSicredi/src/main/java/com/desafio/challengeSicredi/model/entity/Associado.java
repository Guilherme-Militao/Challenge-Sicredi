package com.desafio.challengeSicredi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "ASSOCIADO")
@Table(name = "ASSOCIADO")
@Data
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ASSOCIADO_GENERATOR")
    @SequenceGenerator(name = "SEQUENCE_ASSOCIADO_GENERATOR",sequenceName = "SEQ_ASSOCIADO", allocationSize = 1)
    private Integer idAssociado;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "associado")
    @JsonIgnore
    private List<Voto> votos;


}
