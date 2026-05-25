package com.weg.gestao_escolar.service.turmaAluno;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoRequestDto;
import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoResponseDto;
import com.weg.gestao_escolar.model.TurmaAluno;

public interface TurmaAlunoService {
    TurmaAlunoResponseDto save(TurmaAlunoRequestDto turmaAlunoRequestDto) throws SQLException;

    TurmaAlunoResponseDto get(Long id) throws SQLException;
    
    List<TurmaAlunoResponseDto> getAll() throws SQLException;

    TurmaAlunoResponseDto update(Long id, TurmaAluno turmaAlunoRequestDto) throws SQLException;

    void delete(Long id) throws SQLException;
}
