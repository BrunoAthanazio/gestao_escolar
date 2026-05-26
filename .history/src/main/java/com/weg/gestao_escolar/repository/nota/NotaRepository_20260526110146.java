package com.weg.gestao_escolar.repository.nota;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Curso;
import com.weg.gestao_escolar.model.Nota;

public interface NotaRepository {
    Nota save(Curso curso) throws SQLException;

    Curso get(Long id) throws SQLException;

    List<Curso> getAll() throws SQLException;

    Curso update(Long id, Curso curso) throws SQLException;

    void delete(Long id) throws SQLException;
}
