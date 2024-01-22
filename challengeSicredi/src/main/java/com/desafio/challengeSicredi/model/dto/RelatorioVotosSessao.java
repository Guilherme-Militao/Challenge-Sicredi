package com.desafio.challengeSicredi.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class RelatorioVotosSessao {
    private Integer idSessao;
    private Timestamp finalSessao;
    private Integer qtdVotos;
    private List<RelatorioVotosDto> relatorioVotosDto;
}
