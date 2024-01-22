package com.desafio.challengeSicredi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PautaDtoOut extends PautaDtoIn {

    @Schema(description = "O id da pauta", example = "1")
    private Integer idPauta;
}
