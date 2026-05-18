package com.weg.gestao_escolar.service.curso;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.curso.CursoRequestDto;
import com.weg.gestao_escolar.dto.curso.CursoResponseDto;

public interface CursoService {
    CursoResponseDto save(CursoRequestDto cursoRequest) throws SQLException;

    CursoResponseDto get(Long id) throws SQLException;

    List<CursoResponseDto> getAll() throws SQLException;

    CursoResponseDto update(Long id, CursoRequestDto cursoRequest) throws SQLException;

    void delete(Long id) throws SQLException;
}
