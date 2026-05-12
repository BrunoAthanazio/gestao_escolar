package com.weg.gestao_escolar.repository.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Aluno;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository{

    @Override
    public Aluno save(Aluno aluno) throws SQLException {
        String command = """
                INSERT INTO aluno
                (nome, email, matricula, data_nascimento)
                VALUES
                (?, ?, ?, ?);
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command,
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, aluno.getData_nascimento());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                aluno.setId(rs.getLong(1));
            }
            return aluno;
        }
    }

    @Override
    public Aluno get(Long id) throws SQLException {
        String query = """
                SELECT nome,
                    email,
                    matricula,
                    data_nascimento
                FROM aluno
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Aluno aluno = new Aluno(
                    id, 
                    rs.getString("nome"), 
                    rs.getString("email"),
                    rs.getString("matricula"),
                    rs.getDate("data_nascimento")
                );
                return aluno;
            }
            throw new RuntimeException("Aluno não encontrado");
        }
    }

    @Override
    public List<Aluno> getAll() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String query = """
                SELECT id,
                    nome,
                    email,
                    matricula,
                    data_nascimento
                FROM aluno;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getLong("id"),
                    rs.getString("nome"), 
                    rs.getString("email"),
                    rs.getString("matricula"),
                    rs.getDate("data_nascimento")
                );
                alunos.add(aluno);
            }
            return alunos;
        }
    }

    @Override
    public Aluno update(Long id, Aluno aluno) throws SQLException {
        String command = """
                UPDATE aluno
                SET nome = ?, email = ?, matricula = ?, data_nascimento = ?
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, aluno.getData_nascimento());
            stmt.setLong(5, id);
            stmt.executeUpdate();
            aluno.setId(id);
            return aluno;
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String command = """
                DELETE FROM aluno
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}
