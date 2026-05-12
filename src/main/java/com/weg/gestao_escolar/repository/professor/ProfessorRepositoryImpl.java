package com.weg.gestao_escolar.repository.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Professor;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository{

    @Override
    public Professor save(Professor professor) throws SQLException {
        String command = """
                INSERT INTO professor
                (nome, email, disciplina)
                VALUES
                (?, ?, ?);
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, 
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                professor.setId(rs.getLong(1));
            }
            return professor;
        }
    }

    @Override
    public Professor get(Long id) throws SQLException {
        String query = """
                SELECT nome,
                    email,
                    disciplina
                FROM professor
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Professor professor = new Professor(
                    id,
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("disciplina")
                );
                return professor;
            }
            throw new RuntimeException("Professor não encontrado"); 
        }
    }

    @Override
    public List<Professor> getAll() throws SQLException {
        List<Professor> professores = new ArrayList<>();
        String query = """
                SELECT id,
                    nome,
                    email,
                    disciplina
                FROM professor;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Professor professor = new Professor(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("disciplina")
                );
                professores.add(professor);
            }
            return professores;
        }
    }

    @Override
    public Professor update(Long id, Professor professor) throws SQLException {
        String command = """
                UPDATE professor
                SET nome = ?,
                    email = ?,
                    disciplina = ?
                WHERE id = ?
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setLong(4, id);
            stmt.executeUpdate();
            professor.setId(id);
            return professor;
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String command = """
                DELETE FROM professor
                WHERE id = ?
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}
