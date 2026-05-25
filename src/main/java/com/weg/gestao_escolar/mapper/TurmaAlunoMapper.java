package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoRequestDto;
import com.weg.gestao_escolar.dto.turmaAluno.TurmaAlunoResponseDto;
import com.weg.gestao_escolar.model.TurmaAluno;

@Component
public class TurmaAlunoMapper {
    public TurmaAluno toEntity(TurmaAlunoRequestDto turmaAlunoRequest){
        return new TurmaAluno(turmaAlunoRequest.turma_id(), turmaAlunoRequest.aluno_id());
    }

    public TurmaAlunoResponseDto toResponse(TurmaAluno turmaAluno) {
        return new TurmaAlunoResponseDto(turmaAluno.getTurma_nome(), turmaAluno.getAluno_nome());
    }
}
