package com.weg.gestao_escolar.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.turma.TurmaRequestDto;
import com.weg.gestao_escolar.dto.turma.TurmaResponseDto;
import com.weg.gestao_escolar.service.turma.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private TurmaService turmaService;

    public TurmaController(TurmaService turmaService){
        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaResponseDto postTurma(@RequestBody TurmaRequestDto turmaRequestDto){
        try{
            return turmaService.save(turmaRequestDto);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
