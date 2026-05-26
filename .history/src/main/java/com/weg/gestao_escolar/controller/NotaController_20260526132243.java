package com.weg.gestao_escolar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.nota.NotaRequestDto;
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
    public NotaResponseDto postNota(@RequestBody NotaRequestDto notaRequest){
        try{
            return notaService.save(notaRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public NotaResponseDto getNota(@PathVariable Long id){
        try{
            return notaService.get(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<NotaResponseDto> getNota(){
        try{
            return notaService.getAll();
        }
    }
}
