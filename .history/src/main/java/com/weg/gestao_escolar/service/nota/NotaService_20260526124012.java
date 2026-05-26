package com.weg.gestao_escolar.service.nota;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.model.Nota;

public interface NotaService {
    NotaResponseDto save(Nota nota) throws SQLException;

    Nota get(Long id) throws SQLException;

    List<Nota> getAll() throws SQLException;

    Nota update(Long id, Nota nota) throws SQLException;

    void delete(Long id) throws SQLException;
}
