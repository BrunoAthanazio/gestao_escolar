package com.weg.gestao_escolar.service.turma;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.turma.TurmaRequestDto;
import com.weg.gestao_escolar.dto.turma.TurmaResponseDto;
import com.weg.gestao_escolar.mapper.TurmaMapper;
import com.weg.gestao_escolar.model.Turma;
import com.weg.gestao_escolar.repository.turma.TurmaRepository;

@Service
public class TurmaServiceImpl implements TurmaService{

    private TurmaRepository turmaRepository;
    private TurmaMapper turmaMapper;

    public TurmaServiceImpl(TurmaMapper turmaMapper, TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
        this.turmaMapper = turmaMapper;
    }

    @Override
    public TurmaResponseDto save(TurmaRequestDto turmaRequest) throws SQLException {
        Turma turma = turmaMapper.toEntity(turmaRequest);
        turmaRepository.save(turma);
        TurmaResponseDto turmaResponse = turmaMapper.toResponse(turma);
        return turmaResponse;
    }

    @Override
    public TurmaResponseDto get(Long id) throws SQLException {
        Turma turma = turmaRepository.get(id);
        TurmaResponseDto turmaResponseDto = turmaMapper.toResponse(turma);
        return turmaResponseDto;
    }

    @Override
    public List<TurmaResponseDto> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public TurmaResponseDto update(Long id, TurmaRequestDto turmaRequest) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
