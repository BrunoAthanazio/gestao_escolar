package com.weg.gestao_escolar.service.aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.aluno.AlunoRequestDto;
import com.weg.gestao_escolar.dto.aluno.AlunoResponseDto;
import com.weg.gestao_escolar.mapper.AlunoMapper;
import com.weg.gestao_escolar.model.Aluno;
import com.weg.gestao_escolar.repository.aluno.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService{

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoServiceImpl(AlunoRepository alunoRepository, AlunoMapper alunoMapper){
        this.alunoMapper = alunoMapper;
        this.alunoRepository = alunoRepository;
    }


    @Override
    public AlunoResponseDto save(AlunoRequestDto alunoDto) throws SQLException {
        Aluno aluno = alunoMapper.toEntity(alunoDto);
        alunoRepository.save(aluno);
        return alunoMapper.toResponse(aluno);
    }

    @Override
    public AlunoResponseDto get(Long id) throws SQLException {
        Aluno aluno = alunoRepository.get(id);
        AlunoResponseDto alunoResponse = alunoMapper.toResponse(aluno);
        return alunoResponse;
    }

    @Override
    public List<AlunoResponseDto> getAll() throws SQLException {
        List<AlunoResponseDto> alunoResponses = new ArrayList<>();
        List<Aluno> alunos = alunoRepository.getAll();
        for(Aluno aluno : alunos){
            AlunoResponseDto alunoResponse = alunoMapper.toResponse(aluno);
            alunoResponses.add(alunoResponse);
        }
        return alunoResponses;
    }

    @Override
    public AlunoResponseDto update(Long id, AlunoRequestDto alunoDto) throws SQLException {
        Aluno aluno = alunoMapper.toEntity(alunoDto);
        aluno = alunoRepository.update(id, aluno);
        AlunoResponseDto alunoResponse = alunoMapper.toResponse(aluno);
        return alunoResponse;
    }

    @Override
    public void delete(Long id) throws SQLException {
        alunoRepository.get(id);
        alunoRepository.delete(id);
    }

}
