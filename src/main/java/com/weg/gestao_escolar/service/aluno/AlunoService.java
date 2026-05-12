package com.weg.gestao_escolar.service.aluno;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.aluno.AlunoRequestDto;
import com.weg.gestao_escolar.dto.aluno.AlunoResponseDto;

public interface AlunoService {

    AlunoResponseDto save(AlunoRequestDto alunoDto) throws SQLException;

    AlunoResponseDto get(Long id) throws SQLException;

    List<AlunoResponseDto> getAll() throws SQLException;

    AlunoResponseDto update(Long id, AlunoRequestDto alunoDto) throws SQLException;

    void delete(Long id) throws SQLException;
}
