package com.weg.gestao_escolar.repository.curso;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Curso;

public interface CursoRepository {
    Curso save(Curso curso) throws SQLException;

    Curso get(Long id) throws SQLException;

    List<Curso> getAll() throws SQLException;

    Curso update(Long id, Curso curso) throws SQLException;

    void delete(Long id) throws SQLException;
}
