package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;
import com.weg.gestao_escolar.model.Aula;

@Component
public class AulaMapper {

    public Aula toEntity(AulaRequestDto aulaRequest){
        Aula aula = new Aula(aulaRequest.turma_id(), aulaRequest.data_hora(), aulaRequest.assunto());
        return aula;
    }

    public AulaResponseDto toResponse(Aula aula){
        AulaResponseDto aulaResponse = new AulaResponseDto();
    }
}
