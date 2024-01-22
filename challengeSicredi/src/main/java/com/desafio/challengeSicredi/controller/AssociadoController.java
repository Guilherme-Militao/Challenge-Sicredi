package com.desafio.challengeSicredi.controller;

import com.desafio.challengeSicredi.infra.docs.AssociadoControllerDoc;
import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoIn;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoOut;
import com.desafio.challengeSicredi.model.entity.Associado;
import com.desafio.challengeSicredi.model.service.AssociadoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associado")
@RequiredArgsConstructor
@Validated
public class AssociadoController implements AssociadoControllerDoc {
    private final AssociadoService associadoService;

    @Override
    @GetMapping
    public ResponseEntity<List<Associado>> getAllAssociados(){
        return new ResponseEntity<>(this.associadoService.getAllAssociados(), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<AssociadoDtoOut> saveAssociado(@RequestBody @Valid AssociadoDtoIn associadoDtoIn){
        return new ResponseEntity<>(this.associadoService.saveAssociado(associadoDtoIn),HttpStatus.CREATED);
    }
    @Override
    @PutMapping("/{idAssociado}")
    public ResponseEntity<AssociadoDtoOut> updateAssociado(@PathVariable("idAssociado") @Positive(message = "O numero deve ser posistivo") Integer id,
                                                           @RequestBody @Valid AssociadoDtoIn associadoDtoIn) throws NotFoundException {
        return new ResponseEntity<>(this.associadoService.updateAssociadoById(associadoDtoIn,id),HttpStatus.CREATED);
    }
    @Override
    @DeleteMapping("/delete/{idAssociado}")
    public ResponseEntity<Void> deleteAssociado(@PathVariable("idAssociado") @Positive(message = "O numero deve ser posistivo") Integer id){
        this.associadoService.deleteAssociado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
