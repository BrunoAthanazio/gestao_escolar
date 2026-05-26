package com.weg.gestao_escolar.repository.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Nota;

public class NotaRepositoryImpl implements NotaRepository{

    @Override
    public Nota save(Nota nota) throws SQLException {
        String command = """
                INSERT INTO nota
                (aluno_id, aula_id, valor)
                VALUES
                (?, ?, ?);
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command,
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, nota.getAluno_id())
        }
    }

    @Override
    public Nota get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Nota> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Nota update(Long id, Nota nota) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
