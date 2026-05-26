package com.weg.gestao_escolar.controller;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.service.nota.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {
    
    private NotaService notaService;

    public NotaController(NotaService notaService){
        this.notaService = notaService;
    }

    @PostMapping
    public NotaResponseDto postNota()
}
