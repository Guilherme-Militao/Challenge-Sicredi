package com.desafio.challengeSicredi.model.dto;

import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RelatorioVotosDto {
    private Integer idVoto;
    private Integer idAssociado;
    private ConteudoVoto conteudoVoto;
    private Timestamp infoVoto;
}
