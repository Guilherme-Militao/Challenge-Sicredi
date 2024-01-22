package com.desafio.challengeSicredi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class AssociadoDtoIn {
    @Pattern(regexp = "^[0-9]{11}$",message = "Insira um cpf válido")
    @Schema(description = "O conjunto de numeros do cpf", example = "00100200312", type = "String")
    private String cpf;

    @Email(message = "Insira um email válido")
    @Schema(description = "O email para contato e login", example = "joao@gmail.com", type = "String")
    private String email;

    @NotBlank(message = "O Campo é obriogatorio")
    @Size(min = 0, max = 50, message = "Insira um nome válido")
    @Pattern(message = "Insira um nome válido",regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s']+$")
    @Schema(description = "Insira um nome", example = "João da Silva Sauro",type = "String")
    private String nome;

}
