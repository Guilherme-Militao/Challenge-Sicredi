package com.desafio.challengeSicredi.model.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SessaoDtoOut  extends SessaoDtoIn{

    @Schema(description = "Id da Sessão de votação", example = "1")
    private Integer idSessao;
}
