package com.weg.gestao_escolar.controller;

import org.springframework.web.bind.annotation.PostMapping;


import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @PostMapping
    public AulaResponseDto postAula(AulaRequestDto aulaRequest){

    }
}
