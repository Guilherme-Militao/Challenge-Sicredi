package com.desafio.challengeSicredi.infra.docs;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoIn;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoOut;
import com.desafio.challengeSicredi.model.entity.Associado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AssociadoControllerDoc {

    @Operation(summary ="Listar todos Asocciadoa", description = "Deve retornar uma lista de Asscociados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Operação efetuada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada um excessão")
            }
    )
    @GetMapping
    public ResponseEntity<List<Associado>> getAllAssociados();

    @Operation(summary = "Criar um associdado", description = "Deve criar um associado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deve retornar um Associado Criado"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Um excessão foi gerada")
            }
    )
    @PostMapping
    public ResponseEntity<AssociadoDtoOut> saveAssociado(@RequestBody @Valid AssociadoDtoIn associadoDtoIn);

    @Operation(summary = "Atualiza os dados de um Associado", description ="Deve retornar um assocido atualizado" )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Deve retornar o Associado Atualiaado"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @PutMapping("/{idAssociado}")
    public ResponseEntity<AssociadoDtoOut> updateAssociado(@PathVariable("idAssociado") @Positive(message = "O numero deve ser posistivo") Integer id,
                                                           @RequestBody @Valid AssociadoDtoIn associadoDtoIn) throws NotFoundException;

    @Operation(summary = "Deve Excluir um associado",description = "Deve excluir um Associado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Requisição ok"),
                    @ApiResponse(responseCode = "400", description ="Requisição inválida"),
                    @ApiResponse(responseCode = "500", description = "Uma excessão foi gerada")
            }
    )
    @DeleteMapping("/delete/{idAssociado}")
    public ResponseEntity<Void> deleteAssociado(@PathVariable("idAssociado") @Positive(message = "O numero deve ser posistivo") Integer id);
}
