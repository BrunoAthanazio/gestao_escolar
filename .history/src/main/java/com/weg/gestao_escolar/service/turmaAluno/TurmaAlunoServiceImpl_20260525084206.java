package com.weg.gestao_escolar.service.turmaAluno;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoRequestDto;
import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoResponseDto;
import com.weg.gestao_escolar.mapper.TurmaAlunoMapper;
import com.weg.gestao_escolar.model.TurmaAluno;
import com.weg.gestao_escolar.repository.turmaAluno.TurmaAlunoRepository;

@Service
public class TurmaAlunoServiceImpl implements TurmaAlunoService{

    private TurmaAlunoMapper turmaAlunoMapper;
    private TurmaAlunoRepository turmaAlunoRepository;

    public TurmaAlunoServiceImpl(TurmaAlunoMapper turmaAlunoMapper, TurmaAlunoRepository turmaAlunoRepository);

    @Override
    public TurmaAlunoResponseDto save(TurmaAlunoRequestDto turmaAlunoRequestDto) throws SQLException {
        TurmaAluno turmaAluno = 
    }

    @Override
    public TurmaAlunoResponseDto get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<TurmaAlunoResponseDto> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public TurmaAlunoResponseDto update(Long id, TurmaAluno turmaAlunoRequestDto) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
