package com.desafio.challengeSicredi.infra.docs;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.infra.exceptions.NotOpenedSession;
import com.desafio.challengeSicredi.model.entity.Voto;
import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface VotoControllerDoc {
    @Operation(summary = "Criar um voto", description = "Deve criar um voto")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deve retornar um voto criado"),
                    @ApiResponse(responseCode = "400", description = "Requisição invalida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @PostMapping("/{cpf}/{idSessao}")
    public ResponseEntity<Voto> createVoto(@PathVariable("cpf") @Pattern(regexp = "^[0-9]{11}$",message = "Insira um cpf válido")String cpf,
                                           @PathVariable("idSessao") Integer idSessao,
                                           @RequestParam ConteudoVoto conteudoVoto) throws NotFoundException, NotOpenedSession;
}
