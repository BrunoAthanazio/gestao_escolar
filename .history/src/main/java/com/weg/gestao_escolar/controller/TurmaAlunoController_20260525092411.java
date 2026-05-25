package com.weg.gestao_escolar.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoRequestDto;
import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoResponseDto;
import com.weg.gestao_escolar.service.turmaAluno.TurmaAlunoService;

@RestController
@RequestMapping("/turma_alunos")
public class TurmaAlunoController {
    
    private TurmaAlunoService turmaAlunoService;

    public TurmaAlunoController(TurmaAlunoService turmaAlunoService){
        this.turmaAlunoService = turmaAlunoService;
    }

    @PostMapping
    public TurmaAlunoResponseDto getTurmaAluno(@RequestBody TurmaAlunoRequestDto turmaAlunoRequestDto){
        try{
            return turmaAlunoService.save(turmaAlunoRequestDto);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
