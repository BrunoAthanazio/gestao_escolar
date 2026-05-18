package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.turma.TurmaRequestDto;
import com.weg.gestao_escolar.dto.turma.TurmaResponseDto;
import com.weg.gestao_escolar.model.Turma;

@Component
public class TurmaMapper {
    public Turma toEntity(TurmaRequestDto turmaRequest){
        return new Turma(turmaRequest.nome(), turmaRequest.curso_id(), turmaRequest.professor_id());
    }

    public TurmaResponseDto toResponse(Turma turma){
        return new TurmaResponseDto(turma.getId(), turma.getNome(), turma.getCurso_nome(), turma.getProfessor_nome());
    }
}
