package com.weg.gestao_escolar.controller;

import org.springframework.web.bind.annotation.*;


import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;
import com.weg.gestao_escolar.service.aula.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private AulaService aulaService;

    public AulaController(AulaService aulaService){
        this.aulaService = aulaService;
    }

    @PostMapping
    public AulaResponseDto postAula(AulaRequestDto aulaRequest){
        try{
            aulaService
        }
    }
}
