package com.weg.gestao_escolar.dto.aula;

import java.time.LocalDateTime;

public record AulaResponseDto(
    Long id,
    String turma_nome,
    LocalDateTime data_hora,
    
) {

}
