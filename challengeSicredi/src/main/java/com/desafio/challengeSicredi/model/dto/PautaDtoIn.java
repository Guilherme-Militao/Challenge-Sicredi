package com.desafio.challengeSicredi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class PautaDtoIn {

    @NotBlank(message = "O campo é obrigatório")
    @Size(min = 1, max = 50, message = "O campo deve possuir tamanho válido")
    @Schema(type = "String", description = "Titulo da pauta", example = "Investimento empresas agrícolas")
    private String titulo;


    @NotBlank(message = "O campo é obrigatório")
    @Size(min = 1, max = 250, message = "O campo deve possuir tamanho válido")
    @Schema(description = "Descriçao da pauta", example = "A pauta busca esclarecer tópicos referentes a pauta...")
    private String descricao;
}
