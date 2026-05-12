package com.weg.gestao_escolar.service.professor;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.professor.ProfessorRequestDto;
import com.weg.gestao_escolar.dto.professor.ProfessorResponseDto;

public interface ProfessorService {
    ProfessorResponseDto save(ProfessorRequestDto professorRequest) throws SQLException;

    ProfessorResponseDto get(Long id) throws SQLException;

    List<ProfessorResponseDto> getAll() throws SQLException;

    ProfessorResponseDto update(Long id, ProfessorRequestDto professorRequest) throws SQLException;

    void delete(Long id) throws SQLException;
}
