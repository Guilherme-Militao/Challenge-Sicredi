package com.desafio.challengeSicredi.model.entity;

import com.desafio.challengeSicredi.model.enums.StatusSessao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "SESSAO")
@Table(name = "SESSAO")
@Data
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SESSAO_GENERATED")
    @SequenceGenerator(name = "SEQ_SESSAO_GENERATED",sequenceName = "SEQ_SESSAO", allocationSize = 1)
    private Integer idSessao;

    @Column(name = "TEMPO_DURACAO")
    private Integer tempoDuracao;

    @Column(name = "INICIO_DATE")
    private Timestamp inicioDate;

    @Column(name = "FINAL_DATE")
    private Timestamp finalDate;

    @Column(name = "STATUS_SESSAO")
    @Enumerated(EnumType.STRING)
    private StatusSessao statusSessao;

    @OneToOne
    @JoinColumn(name = "ID_PAUTA")
    private Pauta pauta;

    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Voto> votos;
}
