package com.weg.gestao_escolar.repository.turmaAluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.TurmaAluno;

@Repository
public class TurmaAlunoRepositoryImpl implements TurmaAlunoRepository{

    @Override
    public TurmaAluno save(TurmaAluno turmaAluno) throws SQLException {
        String command = """
                INSERT INTO turma_aluno
                (turma_id, aluno_id)
                VALUES
                (?, ?)
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setLong(1, turmaAluno.getTurma_id());
            stmt.setLong(2, turmaAluno.getAluno_id());
            stmt.executeUpdate();
            return turmaAluno; 
        }
    }

    @Override
    public TurmaAluno get(Long id) throws SQLException {
        String query = """
                SELECT turma.nome, aluno.nome
                FROM turma_aluno
                JOIN turma ON turma_aluno.turma_id = turma.id
                JOIN 
                """; 
    }

    @Override
    public List<TurmaAluno> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public TurmaAluno update(Long id, TurmaAluno turmaAluno) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
