package com.weg.gestao_escolar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.weg.gestao_escolar.dto.professor.ProfessorRequestDto;
import com.weg.gestao_escolar.dto.professor.ProfessorResponseDto;
import com.weg.gestao_escolar.service.professor.ProfessorService;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping()
    public ProfessorResponseDto postProfessor(@RequestBody ProfessorRequestDto professorRequest){
        try{
            return professorService.save(professorRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProfessorResponseDto getProfessor(@PathVariable Long id){
        try{
            return professorService.get(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<ProfessorResponseDto> getProfessor(){
        try{
            return professorService.getAll();
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ProfessorResponseDto putProfessor(@PathVariable Long id, @RequestBody ProfessorRequestDto professorRequest){
        try{
            return professorService.update(id, professorRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id){
        try{
            professorService.delete(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
