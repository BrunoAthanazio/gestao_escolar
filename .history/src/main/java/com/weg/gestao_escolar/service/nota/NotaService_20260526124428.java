package com.weg.gestao_escolar.service.nota;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.nota.NotaRequestDto;
import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.model.Nota;

public interface NotaService {
    NotaResponseDto save(NotaRequestDto notaRequest) throws SQLException;

    NotaResponseDto get(Long id) throws SQLException;

    List<NotaResponseDto> getAll() throws SQLException;

    NotaResponseDto update(Long id, NotaRequestDto notaRequest) throws SQLException;

    void delete(Long id) throws SQLException;
}
