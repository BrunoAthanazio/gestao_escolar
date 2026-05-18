package com.weg.gestao_escolar.dto.turma;

public record TurmaResponseDto(
    Long id,
    String nome,
    String curso_nome,
    String professor_nome
) {

}
