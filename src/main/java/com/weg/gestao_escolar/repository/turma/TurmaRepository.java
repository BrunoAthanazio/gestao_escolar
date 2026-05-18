package com.weg.gestao_escolar.repository.turma;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Turma;

public interface TurmaRepository {

    Turma save(Turma turma) throws SQLException;

    Turma get(Long id) throws SQLException;

    List<Turma> getAll() throws SQLException;

    Turma update(Long id, Turma turma) throws SQLException;

    void delete(Long id) throws SQLException;
}
