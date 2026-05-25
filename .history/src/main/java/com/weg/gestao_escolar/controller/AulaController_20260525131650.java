package com.weg.gestao_escolar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.aluno.AlunoRequestDto;
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
    public AulaResponseDto postAula(@RequestBody AulaRequestDto aulaRequest){
        try{
            return aulaService.save(aulaRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AulaResponseDto getAula(@PathVariable Long id){
        try{
            return aulaService.get(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<AulaResponseDto> getAula(){
        try{
            return aulaService.getAll();
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AulaResponseDto putAula(@PathVariable Long id, @RequestBody AlunoRequestDto alunoRequest){
        try{
            return aulaService.
        }
    }
}
