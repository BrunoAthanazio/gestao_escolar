package com.weg.gestao_escolar.repository.nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.weg.gestao_escolar.infrastructure.ConnectionFactory;
import com.weg.gestao_escolar.model.Nota;

@Repository
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
            stmt.setLong(1, nota.getAluno_id());
            stmt.setLong(2, nota.getAula_id());
            stmt.setDouble(3, nota.getValor());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                nota.setId(rs.getLong(1));
            }
            return nota;
        }
    }

    @Override
    public Nota get(Long id) throws SQLException {
        String query = """
                SELECT aluno.nome,
                    aula.assunto,
                    nota.valor
                FROM nota
                JOIN aluno ON nota.aluno_id = aluno.id
                JOIN aula ON nota.aula_id = aula.id
                WHERE nota.id = ?;
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String aluno_nome = rs.getString("aluno.nome");
                String aula_assunto = rs.getString("aula.assunto");
                Double valor = rs.getDouble("nota.valor");

                Nota nota = new Nota(id, aluno_nome, aula_assunto, valor);
                return nota;
            }
            throw new RuntimeException("Nota não encontrada");
        }
    }

    @Override
    public List<Nota> getAll() throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String query = """
                SELECT nota.id
                    aluno.nome,
                    aula.assunto,
                    nota.valor
                FROM nota
                JOIN aluno ON nota.aluno_id = aluno.id
                JOIN aula ON nota.aula_id = aula.id
                """;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String aluno_nome = rs.getString("aluno.nome");
                String aula_assunto = rs.getString("aula.assunto");
                Double valor = rs.getDouble("nota.valor");

                Nota nota = new Nota(id, aluno_nome, aula_assunto, valor);
                return nota;
            }
            throw new RuntimeException("Nota não encontrada");
        }
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
