package com.desafio.challengeSicredi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "PAUTA")
@Table(name = "PAUTA")
@Data
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_PAUTA_GENERATED" )
    @SequenceGenerator(name = "SEQ_PAUTA_GENERATED",sequenceName = "SEQ_PAUTA",allocationSize = 1)
    private Integer idPauta;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonIgnore
    @OneToOne(cascade =CascadeType.ALL,mappedBy = "pauta")
    private Sessao sessao;

}
