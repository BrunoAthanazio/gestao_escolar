package com.weg.gestao_escolar.repository.aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
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
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(command, 
                PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setLong(1, aula.getTurma_id());
            stmt.setObject(2, aula.getData_hora());
            stmt.setString(3, aula.getAssunto());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                aula.setId(rs.getLong(1));
            }
            return aula;
        }
    }

    @Override
    public Aula get(Long id) throws SQLException {
        String query = """
                SELECT turma.nome,
                    aula.data_hora,
                    aula.assunto
                FROM aula
                JOIN turma ON aula.turma_id = turma.id
                WHERE aula.id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            String turma_nome = rs.getString("turma.nome");
            LocalDateTime data_hora = rs.getObject("aula.data_hora", LocalDateTime.class);
            String assunto = rs.getString("aula.assunto");
            
        }
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
