package com.desafio.challengeSicredi.controller;

import com.desafio.challengeSicredi.infra.docs.PautaControllerDoc;
import com.desafio.challengeSicredi.model.dto.PautaDtoIn;
import com.desafio.challengeSicredi.model.dto.PautaDtoOut;
import com.desafio.challengeSicredi.model.entity.Pauta;
import com.desafio.challengeSicredi.model.service.PautaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pauta")
@RequiredArgsConstructor
@Validated
public class PautaController implements PautaControllerDoc {
    private final PautaService pautaService;

    @Override
    @GetMapping
    public ResponseEntity<List<Pauta>> getAllPautas(){
        return new ResponseEntity<>(this.pautaService.findAll(), HttpStatus.OK);
    }
    @Override
    @PostMapping
    public ResponseEntity<PautaDtoOut> savePauta(@RequestBody @Valid  PautaDtoIn pautaDtoIn){
        return new ResponseEntity<>(this.pautaService.savePauta(pautaDtoIn),HttpStatus.CREATED);
    }
}
