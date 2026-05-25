package com.weg.gestao_escolar.repository.aula;

import java.sql.SQLException;
import java.util.List;

import com.weg.gestao_escolar.model.Aula;

public class AulaRepositoryImpl implements AulaRepository{

    @Override
    public Aula save(Aula aula) throws SQLException {
        String command = """
                INSERT INTO aula
                (turma_id, data_hora, assunto)
                VALUES 
                (?, ?, ?)
                """;
        try(COnne)
    }

    @Override
    public Aula get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Aula> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Aula update(Long id, Aula aula) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
