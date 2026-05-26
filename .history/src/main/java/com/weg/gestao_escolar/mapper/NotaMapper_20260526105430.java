package com.weg.gestao_escolar.mapper;

import org.springframework.stereotype.Component;

import com.weg.gestao_escolar.dto.nota.NotaRequestDto;
import com.weg.gestao_escolar.dto.nota.NotaResponseDto;
import com.weg.gestao_escolar.model.Nota;

@Component
public class NotaMapper {

    public Nota toEntity(NotaRequestDto notaRequest){
        return new Nota(notaRequest.aluno_id(), notaRequest.aula_id(), notaRequest.valor());
    }

    public NotaResponseDto toResponse(Nota nota){
        return 
    }
}
