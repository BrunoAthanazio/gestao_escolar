package com.weg.gestao_escolar.dto.professor;

public record ProfessorResponseDto(
    Long id,
    String nome,
    String email,
    String disciplina
) {

}
