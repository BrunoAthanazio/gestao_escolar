package com.weg.gestao_escolar.repository.aula;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Aula;

public interface AulaRepository {
    Aula save(Aula aula) throws SQLException;

    Aula get(Long id) throws SQLException;

    List<Aluno> getAll() throws SQLException;

    Aluno update(Long id, Aluno aluno) throws SQLException;

    void delete(Long id) throws SQLException;
}
