package com.weg.gestao_escolar.repository.turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Turma;

@Repository
public class TurmaRepositoryImpl implements TurmaRepository{

    @Override
    public Turma save(Turma turma) throws SQLException {
        String command = """
                INSERT INTO turma
                (nome, curso_id, professor_id)
                VALUES
                (?, ?, ?);
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, 
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, turma.getNome());
            stmt.setLong(2, turma.getCurso_id());
            stmt.setLong(3, turma.getProfessor_id());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                turma.setId(rs.getLong(1));
            }
            return turma;
        }
    }

    @Override
    public Turma get(Long id) throws SQLException {
        String query = """
                SELECT turma.nome,
                    curso.nome,
                    professor.nome
                FROM turma
                JOIN curso ON turma.curso_id = curso.id
                JOIN professor ON turma.professor_id = professor.id
                WHERE turma.id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String nome = rs.getString("turma.nome");
                String curso_nome = rs.getString("curso.nome");
                String professor_nome = rs.getString("professor.nome");

                Turma turma = new Turma(id, nome, curso_nome, professor_nome);
                return turma;
            }
            throw new RuntimeException("Turma não encontrada");
        }
    }

    @Override
    public List<Turma> getAll() throws SQLException {
        List<Turma> turmas = new ArrayList<>();
        String query = """
                SELECT turma.id,
                    turma.nome,
                    curso.nome,
                    professor.nome
                FROM turma
                JOIN curso ON turma.curso_id = curso.id
                JOIN professor ON turma.professor_id = professor.id
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("turma.id");
                String nome_turma = rs.getString("turma.nome");
                String nome_curso = rs.getString("curso.nome");
                String nome_professor = rs.getString("professor.nome");

                Turma turma = new Turma(id, nome_turma, nome_curso, nome_professor);
                turmas.add(turma);
            }
            return turmas;
        }
    }

    @Override
    public Turma update(Long id, Turma turma) throws SQLException {
        String command = """
                UPDATE turma
                SET nome = ?, curso_id = ?, professor_id = ?
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setString(1, turma.getNome());
            stmt.setLong(2, turma.getCurso_id());
            stmt.setLong(3, turma.getProfessor_id());
            stmt.setLong(4, id);
            stmt.executeUpdate();
            turma.setId(id);

            return turma;
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String command = """
                DELETE FROM turma
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}
