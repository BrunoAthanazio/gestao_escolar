package com.weg.gestao_escolar.service.turma;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.turma.TurmaRequestDto;
import com.weg.gestao_escolar.dto.turma.TurmaResponseDto;
import com.weg.gestao_escolar.model.Turma;

public interface TurmaService {
    TurmaResponseDto save(TurmaRequestDto turmaRequest) throws SQLException;

    TurmaResponseDto get(Long id) throws SQLException;

    List<TurmaResponseDto> getAll() throws SQLException;

    TurmaResponseDto update(Long id, TurmaRequestDto turmaRequest) throws SQLException;

    void delete(Long id) throws SQLException;
}
