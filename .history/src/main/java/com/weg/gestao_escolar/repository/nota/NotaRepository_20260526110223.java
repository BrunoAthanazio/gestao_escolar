package com.weg.gestao_escolar.repository.nota;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Nota;

public interface NotaRepository {
    Nota save(Nota curso) throws SQLException;

    Nota get(Long id) throws SQLException;

    List<Nota> getAll() throws SQLException;

    Nota update(Long id, Nota curso) throws SQLException;

    void delete(Long id) throws SQLException;
}
