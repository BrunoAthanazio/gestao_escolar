package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.aluno.AlunoRequestDto;
import com.weg.gestao_escolar.dto.aluno.AlunoResponseDto;
import com.weg.gestao_escolar.model.Aluno;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDto alunoDto){
        return new Aluno(alunoDto.nome(), alunoDto.email(), alunoDto.matricula(), alunoDto.data_nascimento());
    }

    public AlunoResponseDto toResponse(Aluno aluno){
        return new AlunoResponseDto(aluno.getId(),aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getData_nascimento());
    }
}
