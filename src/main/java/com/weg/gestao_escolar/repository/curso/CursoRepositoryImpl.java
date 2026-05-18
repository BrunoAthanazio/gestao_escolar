package com.weg.gestao_escolar.repository.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Curso;

@Repository
public class CursoRepositoryImpl implements CursoRepository{

    @Override
    public Curso save(Curso curso) throws SQLException{
        String command = """
                INSERT INTO curso
                (nome, codigo)
                VALUES
                (?, ?);
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, 
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                curso.setId(rs.getLong(1));
            }

            return curso;
        }
    }

    @Override
    public Curso get(Long id) throws SQLException {
        String query = """
                SELECT nome,
                    codigo
                FROM curso
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");

                Curso curso = new Curso(id, nome, codigo);
                return curso;
            }
            throw new RuntimeException("Curso não encontrado");
        }
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String query = """
                SELECT id,
                    nome,
                    codigo
                FROM curso
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");

                Curso curso = new Curso(id, nome, codigo);
                cursos.add(curso);
            }

            return cursos;
        }
    }

    @Override
    public Curso update(Long id, Curso curso) throws SQLException {
        String command = """
                UPDATE curso
                SET nome = ?, codigo = ?
                WHERE id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setLong(3, id);
            stmt.executeUpdate();
            curso.setId(id);
            return curso;
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String command = """
                DELETE FROM curso
                WHERE id = ?
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}
