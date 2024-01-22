package com.desafio.challengeSicredi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class SessaoDtoIn {

    @Positive(message = "O campo deve ser 1 para default ou duração em minutos")
    @Schema(description = "O campo se refere a duração do pleito em minutos", example = "1")
    private Integer tempoDuracao;
}
