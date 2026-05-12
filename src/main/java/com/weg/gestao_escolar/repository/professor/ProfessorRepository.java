package com.weg.gestao_escolar.repository.professor;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Professor;

public interface ProfessorRepository {
    Professor save(Professor professor) throws SQLException;

    Professor get(Long id) throws SQLException;

    List<Professor> getAll() throws SQLException;

    Professor update(Long id, Professor professor) throws SQLException;

    void delete(Long id) throws SQLException;
}
