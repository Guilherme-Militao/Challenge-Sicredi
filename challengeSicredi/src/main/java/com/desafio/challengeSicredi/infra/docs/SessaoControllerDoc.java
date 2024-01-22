package com.desafio.challengeSicredi.infra.docs;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.SessaoDtoIn;
import com.desafio.challengeSicredi.model.dto.SessaoDtoOut;
import com.desafio.challengeSicredi.model.entity.Sessao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SessaoControllerDoc {

    @Operation(summary = "Retorna todas as sessões", description = "Deve retornar uma lista de sessoes existentes")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "deve retornar uma lista de sessões"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @GetMapping
    public ResponseEntity<List<Sessao>> getAllSession();

    @Operation(summary = "Cria uma sessao",description = "Deve criar uma sessao")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deve retornar uma sessao"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @PostMapping("/{idPauta}")
    public ResponseEntity<SessaoDtoOut> createSessao(@RequestBody @Valid SessaoDtoIn sessaoDtoIn,
                                                     @PathVariable("idPauta") @Positive Integer idPauta)throws NotFoundException;
}
