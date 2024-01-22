package com.desafio.challengeSicredi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssociadoDtoOut extends AssociadoDtoIn {
    @Schema(description = "Id do associado",example = "1",type = "Integer")
    private Integer idAssociado;
}
