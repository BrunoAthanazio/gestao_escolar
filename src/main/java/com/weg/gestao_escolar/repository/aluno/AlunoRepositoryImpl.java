package com.weg.gestao_escolar.repository.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Aluno> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Aluno update(Aluno aluno) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
