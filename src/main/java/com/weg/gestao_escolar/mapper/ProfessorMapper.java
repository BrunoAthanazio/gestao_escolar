package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.professor.ProfessorRequestDto;
import com.weg.gestao_escolar.dto.professor.ProfessorResponseDto;
import com.weg.gestao_escolar.model.Professor;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDto professorRequest){
        Professor professor = new Professor(
            professorRequest.nome(),
            professorRequest.email(),
            professorRequest.disciplina()
        );
        return professor;
    }

    public ProfessorResponseDto toResponse(Professor professor){
        ProfessorResponseDto professorResponse = new ProfessorResponseDto(
            professor.getId(),
            professor.getNome(),
            professor.getEmail(),
            professor.getDisciplina()
        );
        return professorResponse;
    }
}
