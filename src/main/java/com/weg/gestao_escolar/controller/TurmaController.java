package com.weg.gestao_escolar.controller;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/{id}")
    public TurmaResponseDto getTurma(@PathVariable Long id){
        try{
            return turmaService.get(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<TurmaResponseDto> getTurma(){
        try{
            return turmaService.getAll();
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public TurmaResponseDto putTurma(@PathVariable Long id, @RequestBody TurmaRequestDto turmaRequest){
        try{
            return turmaService.update(id, turmaRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id){
        try{
            turmaService.delete(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
