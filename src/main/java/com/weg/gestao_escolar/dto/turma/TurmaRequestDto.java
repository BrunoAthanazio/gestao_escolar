package com.weg.gestao_escolar.dto.turma;

public record TurmaRequestDto(
    String nome,
    Long curso_id,
    Long professor_id
) {

}
