package com.desafio.challengeSicredi.model.entity;

import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity(name = "VOTO")
@Table(name = "VOTO")
@Data
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_VOTO_GENERATOR")
    @SequenceGenerator(name = "SEQ_VOTO_GENERATOR",sequenceName = "SEQ_VOTO", allocationSize = 1)
    private Integer idVoto;

    @Column(name = "CONTEUDO")
    @Enumerated(EnumType.STRING)
    private ConteudoVoto conteudoVoto;

    @Column(name = "INFO_VOTO")
    private Timestamp infoVoto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_SESSAO")
    private Sessao sessao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_ASSOCIADO")
    private Associado associado;

}
