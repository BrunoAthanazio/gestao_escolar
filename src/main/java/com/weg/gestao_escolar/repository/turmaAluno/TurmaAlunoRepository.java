package com.weg.gestao_escolar.repository.turmaAluno;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.TurmaAluno;

public interface TurmaAlunoRepository {
    TurmaAluno save(TurmaAluno turmaAluno) throws SQLException;

    TurmaAluno get(Long id) throws SQLException;

    List<TurmaAluno> getAll() throws SQLException;

    TurmaAluno update(Long id, TurmaAluno turmaAluno) throws SQLException;

    void delete(Long id) throws SQLException;
}
