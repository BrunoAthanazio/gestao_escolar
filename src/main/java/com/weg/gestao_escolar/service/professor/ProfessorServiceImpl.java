package com.weg.gestao_escolar.service.professor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.professor.ProfessorRequestDto;
import com.weg.gestao_escolar.dto.professor.ProfessorResponseDto;
import com.weg.gestao_escolar.mapper.ProfessorMapper;
import com.weg.gestao_escolar.model.Professor;
import com.weg.gestao_escolar.repository.professor.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorMapper professorMapper;
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorMapper professorMapper, ProfessorRepository professorRepository){
        this.professorMapper = professorMapper;
        this.professorRepository = professorRepository;
    }

    @Override
    public ProfessorResponseDto save(ProfessorRequestDto professorRequest) throws SQLException {
        Professor professor = professorMapper.toEntity(professorRequest);
        professorRepository.save(professor);
        ProfessorResponseDto professorResponse = professorMapper.toResponse(professor);
        return professorResponse;
    }

    @Override
    public ProfessorResponseDto get(Long id) throws SQLException {
        Professor professor = professorRepository.get(id);
        ProfessorResponseDto professorResponse = professorMapper.toResponse(professor);
        return professorResponse;
    }

    @Override
    public List<ProfessorResponseDto> getAll() throws SQLException {
        List<ProfessorResponseDto> professorResponses = new ArrayList<>();
        List<Professor> professores = professorRepository.getAll();
        for(Professor professor : professores){
            ProfessorResponseDto professorResponse = professorMapper.toResponse(professor);
            professorResponses.add(professorResponse);
        }
        return professorResponses;
    }

    @Override
    public ProfessorResponseDto update(Long id, ProfessorRequestDto professorRequest) throws SQLException {
        Professor professor = professorMapper.toEntity(professorRequest);
        professor = professorRepository.update(id, professor);
        ProfessorResponseDto professorResponse = professorMapper.toResponse(professor);
        return professorResponse;
    }

    @Override
    public void delete(Long id) throws SQLException {
        professorRepository.delete(id);
    }

}
