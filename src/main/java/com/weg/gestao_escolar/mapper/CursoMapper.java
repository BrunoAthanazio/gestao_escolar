package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.curso.CursoRequestDto;
import com.weg.gestao_escolar.dto.curso.CursoResponseDto;
import com.weg.gestao_escolar.model.Curso;

@Component
public class CursoMapper {

    public Curso toEntity(CursoRequestDto cursoRequest){
        return new Curso(cursoRequest.nome(), cursoRequest.codigo());
    }

    public CursoResponseDto toResponse(Curso curso){
        return new CursoResponseDto(curso.getId(), curso.getNome(), curso.getCodigo());
    }
}
