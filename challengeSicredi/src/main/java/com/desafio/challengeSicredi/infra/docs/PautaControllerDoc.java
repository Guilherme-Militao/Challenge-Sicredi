package com.desafio.challengeSicredi.infra.docs;

import com.desafio.challengeSicredi.model.dto.PautaDtoIn;
import com.desafio.challengeSicredi.model.dto.PautaDtoOut;
import com.desafio.challengeSicredi.model.entity.Pauta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PautaControllerDoc {

    @Operation(summary = "Retorna uma lista de Pautas", description = "Deve retornar uma lista com todas as pautas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista com todas as pautas"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @GetMapping
    public ResponseEntity<List<Pauta>> getAllPautas();

    @Operation(summary = "Cria uma pauta", description = "Deve retornar uma pauta criada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deve retornar uma Pauta criada"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @PostMapping
    public ResponseEntity<PautaDtoOut> savePauta(@RequestBody @Valid PautaDtoIn pautaDtoIn);
}
