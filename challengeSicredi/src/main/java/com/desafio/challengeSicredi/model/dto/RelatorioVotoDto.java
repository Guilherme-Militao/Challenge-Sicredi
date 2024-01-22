package com.desafio.challengeSicredi.model.dto;

import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import lombok.Data;

@Data
public class RelatorioVotoDto {
    private Integer idVoto;
    private String cpf;
    private ConteudoVoto conteudoVoto;
}
