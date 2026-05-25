package com.weg.gestao_escolar.service.turma;

import java.sql.SQLException;
import java.util.ArrayList;
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
        turmaRepository.getAll()
    }

    @Override
    public TurmaResponseDto get(Long id) throws SQLException {
        Turma turma = turmaRepository.get(id);
        TurmaResponseDto turmaResponseDto = turmaMapper.toResponse(turma);
        return turmaResponseDto;
    }

    @Override
    public List<TurmaResponseDto> getAll() throws SQLException {
        List<Turma> turmas = turmaRepository.getAll();
        List<TurmaResponseDto> turmaResponses = new ArrayList<>();
        for(Turma turma : turmas){
            TurmaResponseDto turmaResponse = turmaMapper.toResponse(turma);
            turmaResponses.add(turmaResponse);
        }
        return turmaResponses;
    }

    @Override
    public TurmaResponseDto update(Long id, TurmaRequestDto turmaRequest) throws SQLException {
        Turma turma = turmaMapper.toEntity(turmaRequest);
        turma = turmaRepository.update(id, turma);
        return turmaMapper.toResponse(turma);
    }

    @Override
    public void delete(Long id) throws SQLException {
        turmaRepository.get(id);
        turmaRepository.delete(id);
    }

}
