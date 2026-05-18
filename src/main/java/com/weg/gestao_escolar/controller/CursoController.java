package com.weg.gestao_escolar.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.gestao_escolar.dto.curso.CursoRequestDto;
import com.weg.gestao_escolar.dto.curso.CursoResponseDto;
import com.weg.gestao_escolar.service.curso.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping
    public CursoResponseDto postCurso(@RequestBody CursoRequestDto cursoRequest){
        try{
            return cursoService.save(cursoRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CursoResponseDto getCurso(@PathVariable Long id){
        try{
            return cursoService.get(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<CursoResponseDto> getCurso(){
        try{
            return cursoService.getAll();
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public CursoResponseDto putCurso(@PathVariable Long id, @RequestBody CursoRequestDto cursoRequest){
        try{
            return cursoService.update(id, cursoRequest);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id){
        try{
            cursoService.delete(id);
        }catch(SQLException | RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
