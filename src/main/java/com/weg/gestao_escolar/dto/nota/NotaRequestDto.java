package com.weg.gestao_escolar.dto.nota;

public record NotaRequestDto(
    Long aluno_id,
    Long aula_id,
    Double valor
) {

}
